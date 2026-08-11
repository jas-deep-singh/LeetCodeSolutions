class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    public void push(int value) {
        long x = value;
        if(stack.size()==0) {
            stack.push(x);
            min = x;
        }
        else {
            if(x<min) {
                stack.push(2*x-min);
                min = x;
            }
            else {
                stack.push(x);
            }
        }
    }
    public void pop() {
        if(stack.peek()>min) {
            stack.pop();
        }
        else {
            long oldmin = 2*min-stack.peek();
            min = oldmin;
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.peek()>min) {
            return (int)(long)stack.peek();
        }
        else {
            return (int)(long)min;
        }
    }
    public int getMin() {
        return (int)(long)min;
    }
}