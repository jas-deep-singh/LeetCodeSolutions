class Solution {
    public long smallestNumber(long num) {
        long []freq = new long[10];
        boolean isPositive = true;
        if(num<0) {
            isPositive = false;
        }
        while(num!=0) {
            int digit = (int)Math.abs(num%10);
            freq[digit]+=1;
            num = num/10;
        }
        long result = 0;
        if(!isPositive) {
            for(int i=9;i>=0;i--) {
                while(freq[i]>0) {
                    result = result*10+i;
                    freq[i]--;
                }
            }
            result *= -1;
        }
        else {
            for(int i=1;i<10;i++) {
                if(freq[i]>0) {
                    result = result*10+i;
                    freq[i]--;
                    break;
                }
            }
            for(int i=0;i<10;i++) {
                while(freq[i]>0) {
                    result = result*10+i;
                    freq[i]--;
                }
            }
        }
        return result;
    }
}