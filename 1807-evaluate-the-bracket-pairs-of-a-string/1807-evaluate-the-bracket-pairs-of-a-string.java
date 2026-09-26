class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> pair: knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!='(') {
                result.append(s.charAt(i));
            }
            else {
                StringBuilder key = new StringBuilder();
                i++;
                while(s.charAt(i)!=')') {
                    key.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(key.toString())) {
                    result.append(map.get(key.toString()));
                }
                else {
                    result.append("?");
                }
            }
        }
        return result.toString();
    }
}