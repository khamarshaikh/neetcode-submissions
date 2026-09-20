class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character,Character> sTot = new HashMap<>();
        Map<Character,Character> tTos = new HashMap<>();

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(sTot.containsKey(c1) && sTot.get(c1) != c2) {
                return false;
            }
            if(tTos.containsKey(c2) && tTos.get(c2) != c1) {
                return false;
            }
            sTot.put(c1,c2);
            tTos.put(c2,c1);
            
        }
        return true;

    }
}