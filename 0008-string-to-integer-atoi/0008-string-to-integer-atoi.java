class Solution {
    public int recurseHelper(String s, int i, long num, int sign) {
        if(i>=s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign*num);
        }
        num = num*10+(s.charAt(i)-'0');
        if(sign*num<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if(sign*num>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return recurseHelper(s, i+1, num, sign);
    }
    public int myAtoi(String s) {
        int i = 0, sign = 1;
        while(i<s.length() && s.charAt(i)==' ') {
            i++;
        }
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')) {
            sign = s.charAt(i)=='-' ? -1 : 1;
            i++;
        }
        return recurseHelper(s, i, 0, sign);
    }
}