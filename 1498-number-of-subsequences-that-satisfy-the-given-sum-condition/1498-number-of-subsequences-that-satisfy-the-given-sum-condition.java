class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int []pow = new int[nums.length];
        pow[0] = 1;
        for(int i=1;i<nums.length;i++) {
            pow[i] = (pow[i-1]*2)%1000000007;
        }
        int cnt = 0;
        int j = nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]+nums[i]>target) {
                break;
            }
            while(j>i && nums[j]+nums[i]>target) {
                j--;
            }
            cnt = (cnt+(pow[j-i]))%1000000007;
        }
        return cnt;
    }
}