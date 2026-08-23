class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> stack = new ArrayList<>();
        int k = 1;
        for(int num: target) {
            while(k<num) {
                stack.add("Push");
                stack.add("Pop");
                k++;
            }
            stack.add("Push");
            k++;
        }
        return stack;
    }
}