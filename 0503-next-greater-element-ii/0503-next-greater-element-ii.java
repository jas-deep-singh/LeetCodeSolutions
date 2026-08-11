class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int []result = new int[n];
        for(int i=2*n-1;i>=0;i--) {
            int index = i%n;
            while(!stack.isEmpty() && stack.peek()<=nums[index]) {
                stack.pop();
            }
            if(i<n) {
                if(stack.isEmpty()) {
                    result[index] = -1;
                }
                else {
                    result[index] = stack.peek();
                }
            }
            stack.push(nums[index]);
        }
        return result;
    }
}