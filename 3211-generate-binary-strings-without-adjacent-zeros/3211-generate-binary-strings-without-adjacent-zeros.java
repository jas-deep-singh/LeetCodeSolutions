class Solution {
    public boolean checkValidity(String combi) {
        for(int i=1;i<combi.length();i++) {
            if(combi.charAt(i)=='0' && combi.charAt(i)==combi.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }
    public void findAllStrings(List<String> result, int n, String combi) {
        if(combi.length()==n) {
            if(checkValidity(combi)) {
                result.add(combi);
            }
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