class Solution {
    public int findPaths(int cr, int cc, int tr, int tc, int[][] grid, int dir, int[][][] dp) {
        if(cr==tr && cc==tc) {
            return 1;
        }
        if(cr<0 || cc<0 || cr>tr || cc>tc) {
            return 0;
        }
        if(dp[cr][cc][dir]!=-1) {
            return dp[cr][cc][dir];
        }
        if(dir==0 && grid[cr][cc]==1) {
            return dp[cr][cc][dir] = findPaths(cr+1, cc, tr, tc, grid, 1, dp);
        }
        if(dir==1 && grid[cr][cc]==1) {
            return dp[cr][cc][dir] = findPaths(cr, cc+1, tr, tc, grid, 0, dp);
        }
        int right = findPaths(cr, cc+1, tr, tc, grid, 0, dp);
        int down = findPaths(cr+1, cc, tr, tc, grid, 1, dp);
        return dp[cr][cc][dir] = (right+down)%1000000007;
    }
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int [][][]dp = new int[m][n][2];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return findPaths(0, 0, m-1, n-1, grid, 0, dp);
    }
}