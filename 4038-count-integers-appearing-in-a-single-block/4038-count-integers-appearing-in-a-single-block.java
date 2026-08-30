class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> invalid = new HashSet<>();
        int left = 0;
        while(left<nums.length) {
            int right = left;
            while(right<nums.length && nums[left]==nums[right]) {
                right++;
            }
            int x = nums[left];
            if(seen.contains(x)) {
                invalid.add(x);
            }
            else {
                seen.add(x);
            }
            left = right;
        }
        return seen.size()-invalid.size();
    }
}