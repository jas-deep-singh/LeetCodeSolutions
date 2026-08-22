class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int []pse = new int[n];
        int []nse = new int[n];
        int maxArea = Integer.MIN_VALUE;

        stack.push(0);
        pse[0] = -1;
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        stack.push(n-1);
        nse[n-1] = n;
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nse[i] = n;
            }
            else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        
        for(int i=0;i<n;i++) {
            int area = heights[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int []heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j]=='1') {
                    heights[j]+=1;
                }
                else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}