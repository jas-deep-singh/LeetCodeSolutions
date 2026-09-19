class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        boolean leftToRight = true, skipElement = false;
        for(int i=0;i<grid.length;i++) {
            if(leftToRight) {
                for(int j=0;j<grid[0].length;j++) {
                    if(!skipElement) {
                        result.add(grid[i][j]);
                    }
                    skipElement = !skipElement;
                }
            }
            else {
                for(int j=grid[0].length-1;j>=0;j--) {
                    if(!skipElement) {
                        result.add(grid[i][j]);
                    }
                    skipElement = !skipElement;
                }
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
}