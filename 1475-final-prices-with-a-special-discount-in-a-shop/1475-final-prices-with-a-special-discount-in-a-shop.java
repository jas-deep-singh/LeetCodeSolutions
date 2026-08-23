class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int []nse = new int[n];
        int []result = new int[n];
        stack.push(prices[n-1]);
        nse[n-1] = -1;
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()>prices[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nse[i] = -1;
            }
            else {
                nse[i] = stack.peek();
            }
            stack.push(prices[i]);
        }
        for(int i=0;i<n;i++) {
            if(nse[i]==-1) {
                result[i] = prices[i];
            }
            else {
                result[i] = prices[i]-nse[i];
            }
        }
        return result;
    }
}