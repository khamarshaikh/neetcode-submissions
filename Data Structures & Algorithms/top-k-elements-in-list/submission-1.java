class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> result = new HashMap<>();
        for(String str:strs){
            int[] chars = new int[26];

            for(char c : str.toCharArray()) {
                chars[c - 'a']++;
            }

            String k = Arrays.toString(chars);
            // String k = chars.toString();

            result.putIfAbsent(k,new ArrayList<String>());
            result.get(k).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
