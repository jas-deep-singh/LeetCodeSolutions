class Solution {
    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(isNum(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                if(tokens[i].equals("+")) {
                    stack.push(val1+val2);
                }
                else if(tokens[i].equals("-")) {
                    stack.push(val1-val2);
                }
                else if(tokens[i].equals("*")) {
                    stack.push(val1*val2);
                }
                else if(tokens[i].equals("/")) {
                    stack.push(val1/val2);
                }
                else {
                    throw new IllegalArgumentException("Invalid operator");
                }
            }
        }
        return stack.pop();
    }
}