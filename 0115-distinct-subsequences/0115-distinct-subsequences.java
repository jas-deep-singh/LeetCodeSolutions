class Solution {
    public int findSubsequences(String s, String t, int sIdx, int tIdx, int[][] dp) {
        if(tIdx==t.length()) {
            return 1;
        }
        if(sIdx==s.length()) {
            return 0;
        }
        if(dp[sIdx][tIdx]!=-1) {
            return dp[sIdx][tIdx];
        }
        int ans;
        if(s.charAt(sIdx)==t.charAt(tIdx)) {
            ans = findSubsequences(s, t, sIdx+1, tIdx+1, dp) + findSubsequences(s, t, sIdx+1, tIdx, dp);
        }
        else {
            ans = findSubsequences(s, t, sIdx+1, tIdx, dp);
        }
        dp[sIdx][tIdx] = ans;
        return dp[sIdx][tIdx];
    }
    public int numDistinct(String s, String t) {
        int [][]dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++) {
            Arrays.fill(dp[i], -1);
        }
        return findSubsequences(s, t, 0, 0, dp);
    }
}