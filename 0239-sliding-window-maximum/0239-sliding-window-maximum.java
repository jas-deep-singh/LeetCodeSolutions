class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        stack.push(n-1);
        int []nge = new int[n];
        nge[n-1] = n;
        int []maxArr = new int[n-k+1];
        for(int i=n-2;i>=0;i--) {
            while(stack.size()>0 && nums[i]>nums[stack.peek()]) {
                stack.pop();
            }
            if(stack.size()==0) {
                nge[i] = n;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        int j = 0, z = 0;
        for(int i=0;i<n-k+1;i++) {
            if(j>=i+k) {
                j = i;
            }
            int max = nums[j];
            while(j<i+k) {
                max = nums[j];
                j = nge[j];
            }
            maxArr[z++] = max;
        }
        return maxArr;
    }
}