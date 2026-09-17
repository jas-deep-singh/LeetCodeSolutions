class Solution {
    public int findChange(int amount, int[] coins, int idx, int[][] dp) {
        if(idx==coins.length) {
            return amount == 0 ? 1 : 0;
        }
        if(dp[idx][amount]!=-1) {
            return dp[idx][amount];
        }
        int skip = findChange(amount, coins, idx+1, dp);
        if(amount<coins[idx]) {
            return dp[idx][amount] = skip;
        }
        int take = findChange(amount-coins[idx], coins, idx, dp);
        return dp[idx][amount] = skip+take;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        return findChange(amount, coins, 0, dp);
    }
}