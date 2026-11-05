class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int x: arr1) {
            int low = 0, high = arr2.length-1, idx = arr2.length;
            while(low<=high) {
                int mid = low+(high-low)/2;
                if(arr2[mid]>=x-d) {
                    idx = mid;
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
            if(idx==arr2.length || arr2[idx]>x+d) {
                count++;
            }
        }
        return count;
    }
}