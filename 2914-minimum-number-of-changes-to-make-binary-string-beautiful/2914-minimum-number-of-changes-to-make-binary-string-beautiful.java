class Solution {
    public int findMinChanges(String s) {
        if(s.charAt(0)!=s.charAt(1)) {
            return 1;
        }
        return 0;
    }
    public int minChanges(String s) {
        int minChanges = 0;
        for(int i=0;i<s.length();i+=2) {
            minChanges += findMinChanges(s.substring(i, i+2));
        }
        return minChanges;
    }
}