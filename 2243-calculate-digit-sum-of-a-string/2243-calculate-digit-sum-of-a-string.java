class Solution {
    public String findSum(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            sum+=s.charAt(i)-'0';
        }
        return String.valueOf(sum);
    }
    public String digitSum(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        while(str.length() > k) {
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<str.length();i+=k) {
                String group = str.substring(i, Math.min(i+k, str.length()));
                temp.append(findSum(group));
            }
            str = temp;
        }
        return str.toString();
    }
}