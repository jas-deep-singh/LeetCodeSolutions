class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0, maxFruits = 0;
        for(int j=0;j<fruits.length;j++) {
            freq.put(fruits[j], freq.getOrDefault(fruits[j], 0)+1);
            if(freq.size()>2) {
                int fruit = fruits[i];
                freq.put(fruit, freq.get(fruit)-1);
                if(freq.get(fruit)==0) {
                    freq.remove(fruit);
                }
                i++;
            }
            if(freq.size()<=2) {
                maxFruits = Math.max(maxFruits, j-i+1);
            }
        }
        return maxFruits;
    }
}