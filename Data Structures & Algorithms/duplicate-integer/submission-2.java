class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Boolean> charCounted = new HashMap<Integer,Boolean>();
        for(int i=0;i<nums.length;i++) {
            if(charCounted.get(nums[i]) != null){
                return true;
            }
            charCounted.put(nums[i],true);
        }
        return false;
    }
}