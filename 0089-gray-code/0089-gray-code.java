class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int power = (int)Math.pow(2, n);
        for(int i=0;i<power;i++) {
            int grayCode = i^(i>>1);
            result.add(grayCode);
        }
        return result;
    }
}