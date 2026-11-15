class Solution {
    public int numOfSubarrays(int[] arr) {
        long prefixSum = 0, even = 1, odd = 0;
        int mod = 1000000007;
        for(int i=0;i<arr.length;i++) {
            prefixSum+=arr[i];
            if(prefixSum%2==0) {
                even++;
            }
            else {
                odd++;
            }
        }
        long result = (even*odd)%mod;
        return (int)result;
    }
}