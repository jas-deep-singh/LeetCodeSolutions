class Solution {
    public void findAllStrings(List<String> result, int n, String combi) {
        if(combi.length()==n) {
            result.add(combi);
            return;
        }
        findAllStrings(result, n, combi+"1");
        if(combi.length()==0 || combi.charAt(combi.length()-1)!='0') {
            findAllStrings(result, n, combi+"0");
        }
    }
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        findAllStrings(result, n, "");
        return result;
    }
}