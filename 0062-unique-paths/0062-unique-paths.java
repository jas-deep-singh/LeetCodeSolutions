// RECURSION+MEMOIZATION
// class Solution {
//     public int findPaths(int srow, int scol, int erow, int ecol, int[][] dp) {
//         if(srow>=erow || scol>=ecol) {
//             return 0;
//         }
//         if(srow==erow-1 && scol==ecol-1) {
//             return 1;
//         }
//         if(dp[srow][scol]!=-1) {
//             return dp[srow][scol];
//         }
//         dp[srow][scol] = findPaths(srow+1, scol, erow, ecol, dp)+findPaths(srow, scol+1, erow, ecol, dp);
//         return dp[srow][scol];
//     }
//     public int uniquePaths(int m, int n) {
//         int [][]dp = new int[m][n];
//         for(int i=0;i<m;i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return findPaths(0, 0, m, n, dp);
//     }
// }

//TABULATION
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int [][]dp = new int[m][n];
//         for(int i=0;i<m;i++) {
//             for(int j=0;j<n;j++) {
//                 if(i==0 || j==0) {
//                     dp[i][j] = 1;
//                 }
//                 else {
//                     dp[i][j] = dp[i-1][j]+dp[i][j-1];
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

//SPACE OPTIMIZATION
class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[2][n];
        for(int i=0;i<n;i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }
        for(int i=1;i<m;i++) {
            if(i%2!=0) {
                for(int j=1;j<n;j++) {
                    dp[1][j] = dp[1][j-1]+dp[0][j];
                }
                
            }
            else {
                for(int j=1;j<n;j++) {
                    dp[0][j] = dp[0][j-1]+dp[1][j];
                }
            }
        }
        return Math.max(dp[1][n-1], dp[0][n-1]);
    }
}