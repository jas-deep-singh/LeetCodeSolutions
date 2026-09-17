class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int []dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int num: nums) {
            for(int sum=target;sum>=num;sum--) {
                if(dp[sum-num]!=-1) {
                    dp[sum] = Math.max(dp[sum], dp[sum-num]+1);
                }
            }
        }
        return dp[target];
    }
}