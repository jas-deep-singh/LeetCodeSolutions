class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, maxFreq = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j<s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));
            while((j-i+1)-maxFreq>k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)-1);
                i++;
            }
            maxLen = Math.max(maxLen, (j-i+1));
            j++;
        }
        return maxLen;
    }
}