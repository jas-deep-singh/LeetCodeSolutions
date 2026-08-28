class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for(int []interval: intervals) {
            if(result.isEmpty() || result.get(result.size()-1)[1]<interval[0]) {
                result.add(interval);
            }
            else {
                interval[0] = Math.min(interval[0], result.get(result.size()-1)[0]);
                interval[1] = Math.max(interval[1], result.get(result.size()-1)[1]);
                result.remove(result.size()-1);
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}