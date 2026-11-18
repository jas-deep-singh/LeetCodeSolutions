class Solution {
    public int minChanges(String s) {
        int minChanges = 0;
        for(int i=0;i<s.length();i+=2) {
            minChanges += s.charAt(i)!=s.charAt(i+1) ? 1 : 0;
        }
        return minChanges;
    }
}