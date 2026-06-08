class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();

        for(int num: nums) {
            if(map.containsKey(num)) return true;

            map.put(num,true);
        }

        return false;
    }
}