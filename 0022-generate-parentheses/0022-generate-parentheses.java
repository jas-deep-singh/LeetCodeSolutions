class Solution {
    public void findAllCombos(List<String> result, int open, int close, int n, String combi) {
        if(combi.length()==2*n) {
            result.add(combi);
            return;
        }
        if(open<n) {
            findAllCombos(result, open+1, close, n, combi+"(");
        }
        if(close<open) {
            findAllCombos(result, open, close+1, n, combi+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        findAllCombos(result, 0, 0, n, "");
        return result;
    }
}