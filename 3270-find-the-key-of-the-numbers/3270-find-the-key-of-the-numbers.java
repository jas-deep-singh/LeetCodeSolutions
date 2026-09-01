class Solution {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<4;i++) {
            int digit = Math.min(num1%10, Math.min(num2%10, num3%10));
            str.insert(0, digit);
            num1/=10;
            num2/=10;
            num3/=10;
        }
        return Integer.parseInt(str.toString());
    }
}