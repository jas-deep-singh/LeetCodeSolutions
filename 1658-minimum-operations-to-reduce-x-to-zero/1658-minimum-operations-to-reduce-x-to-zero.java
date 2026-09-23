class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++) {
            totalSum+=nums[i];
        }
        int target = totalSum-x;
        if(target<0) {
            return -1;
        }
        if(target==0) {
            return nums.length;
        }
        int left = 0, currentSum = 0, maxLength = -1;
        for(int i=0;i<nums.length;i++) {
            currentSum+=nums[i];
            while(currentSum>target) {
                currentSum-=nums[left];
                left++;
            }
            if(currentSum==target) {
                maxLength = Math.max(maxLength, i-left+1);
            }
        }
        if(maxLength==-1) {
            return -1;
        }
        return nums.length-maxLength;
    }
}