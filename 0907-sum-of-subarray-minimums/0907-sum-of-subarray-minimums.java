class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int []pse = new int[n];
        pse[0] = -1;
        int []nse = new int[n];
        nse[n-1] = n;

        stack.push(0);
        for(int i=1;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                pse[i] = -1;
            }
            else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                nse[i] = n;
            }
            else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        long sum = 0;
        for(int i=0;i<n;i++) {
            long leftCont = i-pse[i];
            long rightCont = nse[i]-i;
            long contri = arr[i]*leftCont*rightCont;
            sum = (sum+contri)%1000000007;
        }
        return (int)sum;
    }
}