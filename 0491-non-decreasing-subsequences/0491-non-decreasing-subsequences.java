class Solution {
    public void findSubsequences(int []nums, List<List<Integer>> result, int idx, List<Integer> subsequence) {
        if(subsequence.size()>=2) {
            result.add(new ArrayList<>(subsequence));
        }
        Set<Integer> used = new HashSet<>();
        for(int i=idx;i<nums.length;i++) {
            if(used.contains(nums[i])) {
                continue;
            }
            if(!subsequence.isEmpty() && nums[i]<subsequence.get(subsequence.size()-1)) {
                continue;
            }
            used.add(nums[i]);
            subsequence.add(nums[i]);
            findSubsequences(nums, result, i+1, subsequence);
            subsequence.remove(subsequence.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(nums, result, 0, new ArrayList<>());
        return result;
    }
}