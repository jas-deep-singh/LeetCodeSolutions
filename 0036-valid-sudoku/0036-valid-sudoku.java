class Solution {
    public boolean isValid(char[][] board, int row, int col, char num) {
        for(int i=0;i<col;i++) {
            if(board[row][i]==num) {
                return false;
            }
        }
        for(int i=0;i<row;i++) {
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
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    char num = board[i][j];
                    board[i][j] = '.';
                    if(isValid(board, i, j, num)==false) {
                        return false;
                    }
                    board[i][j] = num;
                }
            }
        }
        return true;
    }
}