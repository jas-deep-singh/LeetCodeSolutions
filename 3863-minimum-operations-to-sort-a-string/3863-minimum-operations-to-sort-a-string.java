class Solution {
    public int minOperations(String s) {
        int l = s.length();
        char []arr = s.toCharArray();
        boolean sorted = true;
        char min = arr[0], max = arr[0];
        for(int i=1;i<l;i++) {
            if(arr[i]<arr[i-1]) {
                sorted = false;
            }
            min = (char)Math.min(arr[i], min);
            max = (char)Math.max(arr[i], max);
        }
        if(sorted) {
            return 0;
        }
        if(l==2) {
            return -1;
        }
        if(min==arr[0] || max==arr[l-1]) {
            return 1;
        }
        for(int i=1;i<l-1;i++) {
            if(arr[i]==min || arr[i]==max) {
                return 2;
            }
        }
        return 3;
    }
}