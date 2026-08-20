class Solution {
    static int check = 0;
    public boolean isValid(char[][] board, int row, int col, char num) {
        for(int i=0;i<9;i++) {
            if(board[row][i]==num) {
                return false;
            }
        }
        for(int i=0;i<9;i++) {
            if(board[i][col]==num) {
                return false;
            }
        }
        int sRow = row/3*3;
        int sCol = col/3*3;
        for(int i=sRow;i<sRow+3;i++) {
            for(int j=sCol;j<sCol+3;j++) {
                if(board[i][j]==num) {
                    return false;
                }
            }
        }
        return true;
    }
    public void solve(char[][] board, int row, int col) {
        if(row==9) {
            check = 1;
            return;
        }
        if(board[row][col]!='.') {
            if(col!=8) {
                solve(board, row, col+1);
            }
            else {
                solve(board, row+1, 0);
            }
        }
        else {
            for(char i='1';i<='9';i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if(col!=8) {
                        solve(board, row, col+1);
                    }
                    else {
                        solve(board, row+1, 0);
                    }
                    if(check==1) {
                        return;
                    }
                    board[row][col] = '.';
                }
            }
        }
    }
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        check = 0;
    }
}