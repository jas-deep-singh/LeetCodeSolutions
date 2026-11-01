class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int num: nums) {
            if(num<min) {
                min = num;
            }
        }
        return min;
    }
    public int minMoves(int[] nums) {
        int min = findMin(nums);
        int moves = 0;
        for(int num: nums) {
            moves+=(num-min);
        }
        return moves;
    }
}