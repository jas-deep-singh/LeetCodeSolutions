class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int []firstOccurence = new int[26];
        int []lastOccurence = new int[26];
        Arrays.fill(firstOccurence, n);
        Arrays.fill(lastOccurence, -1);
        for(int i=0;i<n;i++) {
            int ch = s.charAt(i)-'a';
            firstOccurence[ch] = Math.min(firstOccurence[ch], i);
            lastOccurence[ch] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for(int i=0;i<26;i++) {
            if(lastOccurence[i]==-1) {
                continue;
            }
            int f = firstOccurence[i];
            int l = lastOccurence[i];
            boolean valid = true;
            for(int j=f;j<=l;j++) {
                int curr = s.charAt(j)-'a';
                if(firstOccurence[curr]<f) {
                    valid = false;
                    break;
                }
                l = Math.max(l, lastOccurence[curr]);
            }
            if(valid) {
                intervals.add(new int[]{f, l});
            }
        }
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for(int []interval: intervals) {
            int f = interval[0];
            int l = interval[1];
            if(f>prevEnd) {
                result.add(s.substring(f, l+1));
                prevEnd = l;
            }
        }
        return result;
    }
}