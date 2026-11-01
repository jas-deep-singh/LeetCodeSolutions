class Solution {
    public int findConcate(int i, int j) {
        return Integer.parseInt(String.valueOf(i)+String.valueOf(j));
    }
    public int minMergedInteger(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i+=2) {
            int value = findConcate(nums[i], nums[i+1]);
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }
}