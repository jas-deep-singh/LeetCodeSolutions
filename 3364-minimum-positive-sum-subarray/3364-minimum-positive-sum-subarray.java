class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++) {
            int sum = 0, count = 0; 
            for(int j=i;j<nums.size();j++) {
                sum+=nums.get(j);
                count+=1;
                if((count>=l && count<=r) && sum>0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum!=Integer.MAX_VALUE ? minSum : -1;
    }
}