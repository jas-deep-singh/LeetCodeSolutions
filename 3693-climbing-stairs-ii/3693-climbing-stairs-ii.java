class Solution {
    public int findMinCost(int n, int[] costs, int[] dp) {
        if(n==0) {
            return 0;
        }
        if(dp[n]!=-1) {
            return dp[n];
        }
        int minCost = Integer.MAX_VALUE;
        if(n>=1) {
            minCost = Math.min(minCost, findMinCost(n-1, costs, dp)+costs[n-1]+1);
        }
        if(n>=2) {
            minCost = Math.min(minCost, findMinCost(n-2, costs, dp)+costs[n-1]+4);
        }
        if(n>=3) {
            minCost = Math.min(minCost, findMinCost(n-3, costs, dp)+costs[n-1]+9);
        }
        return dp[n] = minCost;
    }
    public int climbStairs(int n, int[] costs) {
        int []dp = new int[n+1];    
        Arrays.fill(dp, -1);
        return findMinCost(n, costs, dp);
    }
}