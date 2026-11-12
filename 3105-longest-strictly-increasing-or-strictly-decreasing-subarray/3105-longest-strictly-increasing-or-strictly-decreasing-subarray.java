class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count = 1, incLength = 1, decLength = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]) {
                count++;
            }
            else {
                count = 1;
            }
            incLength = Math.max(incLength, count);
        }
        count = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<nums[i-1]) {
                count++;
            }
            else {
                count = 1;
            }
            decLength = Math.max(decLength, count);
        }
        return Math.max(incLength, decLength);
    }
}