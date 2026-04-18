class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexes = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(indexes.containsKey(diff)) {
                return new int[]{indexes.get(diff),i};
            }
            indexes.put(nums[i],i);
        }

        return new int[]{};
    }
}
