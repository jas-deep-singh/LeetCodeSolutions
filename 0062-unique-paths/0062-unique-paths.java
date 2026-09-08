class Solution {
    public int findPaths(int srow, int scol, int erow, int ecol, int[][] dp) {
        if(srow>=erow || scol>=ecol) {
            return 0;
        }
        if(srow==erow-1 && scol==ecol-1) {
            return 1;
        }
        if(dp[srow][scol]!=-1) {
            return dp[srow][scol];
        }
        dp[srow][scol] = findPaths(srow+1, scol, erow, ecol, dp)+findPaths(srow, scol+1, erow, ecol, dp);
        return dp[srow][scol];
    }
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        return findPaths(0, 0, m, n, dp);
    }
}