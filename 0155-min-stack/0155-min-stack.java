class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minimum;
    public MinStack() {
        stack = new Stack<>();
        minimum = new Stack<>();
    }
    public void push(int value) {
        if(stack.size()==0) {
            stack.push(value);
            minimum.push(value);
        }
        else {
            stack.push(value);
            if(value<minimum.peek()) {
                minimum.push(value);
            }
            else {
                minimum.push(minimum.peek());
            }
        }
    }
    public void pop() {
        stack.pop();
        minimum.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minimum.peek();
    }
}