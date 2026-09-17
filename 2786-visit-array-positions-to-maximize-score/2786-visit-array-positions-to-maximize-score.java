class Solution {
    public long findMaxScore(int[] nums, int x, int idx, long[][] dp, int parity) {
        if(idx==nums.length) {
            return 0;
        }
        if(dp[idx][parity]!=-1) {
            return dp[idx][parity];
        }
        long skip = findMaxScore(nums, x, idx+1, dp, parity);
        int penalty = parity!=(nums[idx]%2) ? x : 0;
        long take = nums[idx]-penalty+findMaxScore(nums, x, idx+1, dp, nums[idx]%2); 
        return dp[idx][parity] = Math.max(skip, take);
    }
    public long maxScore(int[] nums, int x) {
        int n = nums.length, sum = 0;
        long [][]dp = new long[n][2];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        return findMaxScore(nums, x, 0, dp, nums[0]%2);
    }
}