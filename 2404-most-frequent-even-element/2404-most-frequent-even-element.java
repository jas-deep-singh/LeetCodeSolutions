class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            }
        }
        if(freq.isEmpty()) {
            return -1;
        }
        int maxFreq = 0, ans = -1;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count>maxFreq) {
                maxFreq = count;
                ans = num;
            }
            if(count==maxFreq && num<ans) {
                ans = num;
            }
        }
        return ans;
    }
}