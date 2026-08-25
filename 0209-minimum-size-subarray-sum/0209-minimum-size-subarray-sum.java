class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, size = Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++) {
            sum+=nums[j];
            while(sum>=target) {
                size = Math.min(size, j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return size==Integer.MAX_VALUE ? 0 : size;
    }
}