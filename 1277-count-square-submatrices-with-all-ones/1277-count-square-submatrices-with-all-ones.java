class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    continue;
                }
                if(i==0 || j==0) {
                    count+=matrix[i][j];
                }
                else {
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                    count+=matrix[i][j];
                }
            }
        }
        return count;
    }
}