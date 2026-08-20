class Solution {
    public void findSubsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        subsets.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i]==nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            findSubsets(subsets, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubsets(subsets, subset, nums, 0);
        return subsets;
    }
}