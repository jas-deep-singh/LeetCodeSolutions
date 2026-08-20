class Solution {
    
    public void findTargetSum(int[] candidates, List<List<Integer>> result, List<Integer> checkSum, int target, int index, int sum) {
        if(sum>target) {
            return;
        }
        if(sum==target) {
            result.add(new ArrayList<>(checkSum));
            return;
        }
        for(int i=index;i<candidates.length;i++) {
            checkSum.add(candidates[i]);
            findTargetSum(candidates, result, checkSum, target, i, sum+candidates[i]);
            checkSum.remove(checkSum.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> checkSum = new ArrayList<>();
        findTargetSum(candidates, result, checkSum, target, 0, 0);
        return result;
    }
}