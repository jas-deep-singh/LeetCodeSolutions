class Solution {
    public int findWays(int[] nums, int target, int idx, int[][] dp, int total) {
        if(idx==nums.length) {
            if(target==0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if(target>total || target<-total) {
            return 0;
        }
        if(dp[idx][target+total]!=-1) {
            return dp[idx][target+total];
        }
        int add = findWays(nums, target+nums[idx], idx+1, dp, total);
        int sub = findWays(nums, target-nums[idx], idx+1, dp, total);
        return dp[idx][target+total] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num: nums) {
            total+=num;
        }
        if(target>total || target<-total) {
            return 0;
        }
        int [][]dp = new int[n][2*total+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }   
        return findWays(nums, target, 0, dp, total);
    }
}