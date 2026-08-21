class Solution {
    public boolean isPallindrome(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++) {
            if(!(s.charAt(i)==s.charAt(n-i-1))) {
                return false;
            }
        }
        return true;
    }
    public void findPartitions(List<List<String>> result, List<String> sub, String s, int idx) {
        if(idx==s.length()) {
            result.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<s.length();i++) {
            String part = s.substring(idx, i+1);
            if(isPallindrome(part)) {
                sub.add(part);
                findPartitions(result, sub, s, i+1);
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        findPartitions(result, sub, s, 0);
        return result;
    }
}