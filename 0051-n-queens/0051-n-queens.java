class Solution {
    public boolean isSafeToPlace(List<String> rowList, int row, int col, int n) {
        for(int i=0;i<row;i++) {
            if(rowList.get(i).charAt(col)=='Q') {
                return false;
            }
        }
        int i = row-1, j = col-1;
        while(i>=0 && j>=0) {
            if(rowList.get(i).charAt(j)=='Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row-1; 
        j = col+1;
        while(i>=0 && j<n) {
            if(rowList.get(i).charAt(j)=='Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public void placeQueens(List<List<String>> result, List<String> rowList, int n, int row) {
        if(row==n) {
            result.add(new ArrayList<>(rowList));
            return;
        }
        for(int i=0;i<n;i++) {
            if(isSafeToPlace(rowList, row, i, n)) {
                StringBuilder rowString = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(j==i) {
                        rowString.append("Q");
                    } else {
                        rowString.append(".");
                    }
                }
                rowList.add(rowString.toString());
                placeQueens(result, rowList, n, row+1);
                rowList.remove(rowList.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> rowList = new ArrayList<>();
        placeQueens(result, rowList, n, 0);
        return result;
    }
}