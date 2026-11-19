class Solution {
    public boolean isMatching(String s, String p, int i, int j, Boolean[][] dp) {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0) {
            for(int k=0;k<=j;k++) {
                if(p.charAt(k)!='*') {
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            return dp[i][j] = isMatching(s, p, i-1, j-1, dp);
        }
        if(p.charAt(j)=='*') {
            return dp[i][j] = (isMatching(s, p, i, j-1, dp) || isMatching(s, p, i-1, j, dp));
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean [][]dp = new Boolean[m][n];
        return isMatching(s, p, m-1, n-1, dp);
    }
}