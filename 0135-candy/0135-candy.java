class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = n, i = 1;
        while(i<n) {
            while(i<n && ratings[i]==ratings[i-1]) {
                i++;
                continue;
            }
            int peak = 0;
            while(i<n && ratings[i]>ratings[i-1]) {
                peak++;
                candies+=peak;
                i++;
            }
            int valley = 0;
            while(i<n && ratings[i]<ratings[i-1]) {
                valley++;
                candies+=valley;
                i++;
            }
            candies-=Math.min(peak, valley);
        }
        return candies;
    }
}