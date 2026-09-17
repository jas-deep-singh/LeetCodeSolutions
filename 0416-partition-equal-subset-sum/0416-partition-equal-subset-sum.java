class Solution {
    public boolean findPartitions(int[] nums, int idx, Boolean[][] dp, int sum) {
        if(sum==0) {
            return true;
        }
        if(idx==nums.length) {
            return false;
        }
        if(dp[idx][sum]!=null) {
            return dp[idx][sum];
        }
        boolean skip = findPartitions(nums, idx+1, dp, sum);
        if(nums[idx]>sum) {
            return dp[idx][sum] = skip;
        }
        boolean take = findPartitions(nums, idx+1, dp, sum-nums[idx]);
        return dp[idx][sum] = skip || take;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum+=num;
        }
        if(sum%2!=0) {
            return false;
        }
        Boolean [][]dp = new Boolean[nums.length][sum/2+1];
        return findPartitions(nums, 0, dp, sum/2);
    }
}