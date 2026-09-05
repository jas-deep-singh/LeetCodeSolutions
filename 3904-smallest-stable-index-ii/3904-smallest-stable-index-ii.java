class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int []prefMax = new int[n];
        int []suffMin = new int[n];
        int minStable = Integer.MAX_VALUE, index = -1;
        prefMax[0] = nums[0];
        suffMin[n-1] = nums[n-1];
        for(int i=1;i<n;i++) {
            prefMax[i] = Math.max(nums[i], prefMax[i-1]);
        }
        for(int i=n-2;i>=0;i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i+1]);
        }
        for(int i=0;i<n;i++) {
            nums[i] = prefMax[i]-suffMin[i];
            if(nums[i]<=k) {
                if(nums[i]<minStable) {
                    return i;
                }
            }
        }
        return index;
    }
}