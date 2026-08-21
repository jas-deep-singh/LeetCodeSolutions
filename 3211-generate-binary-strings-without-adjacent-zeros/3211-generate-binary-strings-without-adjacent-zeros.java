class Solution {
    public void findAllStrings(List<String> result, int n, String combi) {
        if(combi.length()>=2) {
            if(combi.charAt(combi.length()-1)=='0' && combi.charAt(combi.length()-1)==combi.charAt(combi.length()-2)) {
                return;
            }
        }
        if(combi.length()==n) {
            result.add(combi);
            return;
        }
        for(int i=0;i<2;i++) {
            findAllStrings(result, n, combi+(i+""));
        }
    }
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        findAllStrings(result, n, "");
        return result;
    }
}