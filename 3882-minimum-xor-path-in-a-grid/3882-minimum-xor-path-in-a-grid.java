class Solution {
    public int findMinXor(int[][] grid, int cr, int cc, int xor, int[][][] dp) {
        int m = grid.length, n = grid[0].length;
        if(cr>=m || cc>=n) {
            return Integer.MAX_VALUE;
        }
        xor ^= grid[cr][cc]; 
        if(cr==m-1 && cc==n-1) {
            return xor;
        }
        if(dp[cr][cc][xor]!=-1) {
            return dp[cr][cc][xor];
        }
        int right = findMinXor(grid, cr, cc+1, xor, dp);
        int down = findMinXor(grid, cr+1, cc, xor, dp);
        return dp[cr][cc][xor] = Math.min(right, down);
    }
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int [][][]dp = new int[m][n][1024];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return findMinXor(grid, 0, 0, 0, dp);
    }
}