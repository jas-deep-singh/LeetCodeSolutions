class Solution {
    int MOD = 1_000_000_007;
    public int findSubsequences(String s, int idx, int[] dp, int[] lastOccur) {
        if(idx==s.length()) {
            return dp[idx];
        }
        int c = s.charAt(idx)-'a';
        dp[idx+1] = (2*dp[idx])%MOD;
        dp[idx+1] = (dp[idx+1]-lastOccur[c]+MOD)%MOD;
        lastOccur[c] = dp[idx];
        return findSubsequences(s, idx+1, dp, lastOccur);
    }
    public int distinctSubseqII(String s) {
        int n = s.length();
        int []dp = new int[n+1];
        dp[0] = 1;
        int []lastOccur = new int[26];
        return (findSubsequences(s, 0, dp, lastOccur)-1+MOD)%MOD;
    }
}