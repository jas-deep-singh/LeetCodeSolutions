class Solution {
    public void findPermutations(int[] nums, int idx, List<List<Integer>> result) {
        if(idx==nums.length-1) {
            List<Integer> permutation = new ArrayList<>();
            for(int i=0;i<nums.length;i++) {
                permutation.add(nums[i]);
            } 
            result.add(permutation);
            return;
        }
        for(int i=idx;i<nums.length;i++) {
            swap(i, idx, nums);
            findPermutations(nums, idx+1, result);
            swap(i, idx, nums);
        }
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(nums, 0, result);
        return result;
    }
}