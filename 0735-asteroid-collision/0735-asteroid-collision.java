class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++) {
            int curr = asteroids[i];
            while(!stack.isEmpty() && (stack.peek()>0 && curr<0)) {
                if(-curr>stack.peek()) {
                    stack.pop();
                }
                else if(-curr==stack.peek()) {
                    stack.pop();
                    curr = 0;
                    break;
                }
                else {
                    curr = 0;
                    break;
                }
            }
            if(curr!=0) {
                stack.push(asteroids[i]);
            }
        }
        int []result = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}