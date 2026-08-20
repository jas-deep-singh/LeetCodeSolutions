class Solution {
    public void findCombinations(List<List<Integer>> result, int k, int n, List<Integer> combi, int index) {
        if(k==0 && n==0) {
            result.add(new ArrayList<>(combi));
            return;
        }
        for(int i=index;i<=9;i++) {
            combi.add(i);
            findCombinations(result, k-1, n-i, combi, i+1);
            combi.remove(combi.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        findCombinations(result, k, n, combi, 1);
        return result;
    }
}