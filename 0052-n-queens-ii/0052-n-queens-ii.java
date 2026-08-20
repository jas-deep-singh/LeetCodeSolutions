class Solution {
    public boolean isSafeToPlace(int[] queens, int row, int col, int n) {
        for(int i=0;i<row;i++) {
            int c = queens[i];
            if(c==col) {
                return false;
            }
            if(Math.abs(i-row)==Math.abs(c-col)) {
                return false;
            }
        }
        return true;
    }
    public int placeQueens(int[] queens, int n, int row) {
        if(n==row) {
            return 1;
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            if(isSafeToPlace(queens, row, i, n)) {
                queens[row] = i;
                count += placeQueens(queens, n, row+1);
                queens[row] = -1;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        int []queens = new int[n];
        for(int i=0;i<n;i++) {
            queens[i] = -1;
        }
        return placeQueens(queens, n, 0);
    }
}