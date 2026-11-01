class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int operations = 0, max = 0;
        for(int i=0;i<nums.length;i++) {
            int pm = max;
            max = Math.max(max, nums[i]);
            if((pm>i || max>i+1) && (locked[i]==1)) {
                operations++;
            }
        }
        if(operations>k) {
            return -1;
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]>nums[j]) {
                    operations+=1;
                }
            }
        }
        return operations;
    }
}