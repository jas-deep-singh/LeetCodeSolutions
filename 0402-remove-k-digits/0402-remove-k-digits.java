class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c: num.toCharArray()) {
            while(!stack.isEmpty() && k>0 && stack.peek()>c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        int i = 0;
        while(i<result.length() && result.charAt(i)=='0') {
            i++;
        }
        result = new StringBuilder(result.substring(i));
        if(result.length()==0) {
            return "0";
        }
        return result.toString();
    }
}