class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c=='(') {
                stack.push(current.toString());
                current.setLength(0);
            }
            else if(c==')') {
                current.reverse();
                String previous = stack.pop();
                current.insert(0, previous);
            }
            else {
                current.append(c);
            }
        }
        return current.toString();
    }
}