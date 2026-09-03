class Solution {
    public int findTribonacci(int n, int[] dp) {
        if(n==0) {
            return 0;
        }
        if(n<=2) {
            return 1;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        dp[n] = findTribonacci(n-1, dp)+findTribonacci(n-2, dp)+findTribonacci(n-3, dp);
        return dp[n];
    }
    public int tribonacci(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findTribonacci(n, dp);
    }
}