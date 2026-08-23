class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int []nge = new int[n];
        int []result = new int[n];
        nge[n-1] = -1;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nge[i] = -1;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++) {
            if(nge[i]!=-1) {
                result[i] = nge[i]-i;
            }
            else {
                result[i] = 0;
            }
        }
        return result;
    }
}