class Solution {
    public boolean isPerfectSquare(int n) {
        int sqrt = (int)(Math.sqrt(n));
        return (sqrt*sqrt==n);
    }
    public int findNumSquares(int n, int[] dp) {
        if(isPerfectSquare(n)) {
            return 1;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            int count = findNumSquares(i*i, dp)+findNumSquares(n-i*i, dp);
            dp[n] = min = Math.min(min, count);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findNumSquares(n, dp);
    }
}