class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i<nums.length) {
            int j = i+1;
            while(j<nums.length && nums[j-1]+1==nums[j]) {
                j++;
            }
            if(i==(j-1)) {
                result.add(nums[i]+"");
            }
            else {
                result.add(nums[i]+"->"+nums[j-1]);
            }
            i = j;
        }
        return result;
    }
}