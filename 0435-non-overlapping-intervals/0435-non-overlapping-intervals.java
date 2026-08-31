class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int []lastVisited = intervals[0];
        int cnt = 0; 
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]<lastVisited[1]) {
                cnt+=1;
            }
            else {
                lastVisited = intervals[i];
            }
        }
        return cnt;
    }
}