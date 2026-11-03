class Solution {
    public int findMax(int[] nums) {
        int max = nums[0];
        for(int num: nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    public int minMoves(int[] nums) {
        int max = findMax(nums);
        int moves = 0;
        for(int num: nums) {
            moves+=(max-num);
        }
        return moves;
    }
}