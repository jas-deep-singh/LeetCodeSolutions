class Solution {
    public boolean helper(char[][] board, String word, int i, int j, int k) {
        if(k==word.length()-1 && word.charAt(k)==board[i][j]) {
            return true;
        }
        if(board[i][j]==word.charAt(k)) {
            char ch = board[i][j];
            board[i][j] = '0';
            if(i>0 && helper(board, word, i-1, j, k+1)) {
                return true;
            }
            if(i<board.length-1 && helper(board, word, i+1, j, k+1)) {
                return true;
            }
            if(j<board[0].length-1 && helper(board, word, i, j+1, k+1)) {
                return true;
            }
            if(j>0 && helper(board, word, i, j-1, k+1)) {
                return true;
            }
            board[i][j] = ch;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}