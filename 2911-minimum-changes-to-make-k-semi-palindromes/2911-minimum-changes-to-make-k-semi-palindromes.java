class Solution {
    public int getChanges(String s, int l, int r, List<List<Integer>> divisors) {
        int len = r-l+1, minChanges = Integer.MAX_VALUE/2;
        for(int d: divisors.get(len-1)) {
            int part = len/d, changes = 0;
            for(int i=0;i<d;i++) {
                for(int j=0;j<part/2;j++) {
                    if(s.charAt(l+j*d+i)!=s.charAt(l+(part-j-1)*d+i)) {
                        changes+=1;
                    }
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        return minChanges;
    }
    public int find(int n, int k, int start, int[][] dp, int[][] changes) {
        if(start==n) {
            return k==0 ? 0 : Integer.MAX_VALUE/2;
        }
        if(k==0) {
            return Integer.MAX_VALUE/2;
        }
        if(dp[start][k]!=-1) {
            return dp[start][k];
        }
        int result = Integer.MAX_VALUE/2;
        for(int i=start;i<n;i++) {
            result = Math.min(result, changes[start][i]+find(n, k-1, i+1, dp, changes));
        }
        return dp[start][k] = result;
    }
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int [][]dp = new int[n+1][n+1];
        int [][]changes = new int[n+1][n+1];
        List<List<Integer>> divisors = new ArrayList<>();
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++) {
            divisors.add(new ArrayList<>());
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<i;j++) {
                if(i%j==0) {
                    divisors.get(i-1).add(j);
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                changes[i][j] = getChanges(s, i, j, divisors);
            }
        }
        return find(n, k, 0, dp, changes);
    }
}