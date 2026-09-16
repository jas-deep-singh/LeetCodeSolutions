public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n, result = 0;
        while(low<=high) {
            int mid = low+(high-low)/2;
            boolean res = isBadVersion(mid);
            if(res) {
                result = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return result;
    }
}