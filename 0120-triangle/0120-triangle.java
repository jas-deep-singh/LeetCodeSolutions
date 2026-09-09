class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int result = Integer.MAX_VALUE;
        for(int i=1;i<n;i++) {
            for(int j=0;j<triangle.get(i).size();j++) {
                if(j==0) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j));
                }
                else if(j==triangle.get(i).size()-1) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                }
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                }
            }
        }
        for(int i=0;i<triangle.get(n-1).size();i++) {
            result = Math.min(result, triangle.get(n-1).get(i));
        }
        return result;
    }
}