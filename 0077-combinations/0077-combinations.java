class Solution {
    public void findCombinations(List<List<Integer>> result, int idx, int n, int k, List<Integer> list) {
        if(k==0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<=n;i++) {
            list.add(i);
            findCombinations(result, i+1, n, k-1, list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinations(result, 1, n, k, list);
        return result;
    }
}