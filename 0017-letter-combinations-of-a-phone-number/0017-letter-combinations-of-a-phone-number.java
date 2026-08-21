class Solution {
    public void findAllCombinations(List<String> result, String digits, int index, String combi, String[] map) {
        if(index==digits.length()) {
            result.add(combi);
            return;
        }
        String s = map[digits.charAt(index)-'0'];
        for(int i=0;i<s.length();i++) {
            findAllCombinations(result, digits, index+1, combi+s.charAt(i), map);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String []map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findAllCombinations(result, digits, 0, "", map);
        return result;
    }
}