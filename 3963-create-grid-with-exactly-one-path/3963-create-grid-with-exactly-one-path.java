class Solution {
    public String[] createGrid(int m, int n) {
        char [][]matrix = new char[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = '#';
            }
        }
        for(int i=0;i<n;i++) {
            matrix[0][i] = '.';
        }
        for(int i=0;i<m;i++) {
            matrix[i][n-1] = '.';
        }
        String []result = new String[m];
        for(int i=0;i<m;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++) {
                sb.append(matrix[i][j]);
            }
            result[i] = sb.toString();
        }
        return result;
    }
}