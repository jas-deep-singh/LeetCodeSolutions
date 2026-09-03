class Solution {
    public int findFibonacci(int n, int[] dp) {
        if(n<=1) {
            return n;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        dp[n] = findFibonacci(n-1, dp)+findFibonacci(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        int []dp = new int[n+1];
        return findFibonacci(n, dp);
    }
}