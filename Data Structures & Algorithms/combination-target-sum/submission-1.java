class Solution {

    List<List<Integer>> result;
    public void findTargetSum(int[] nums, int target, List<Integer> cur, int currentIndex) {

        if (target == 0) {
            result.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || currentIndex>=nums.length) {
            return;
        }
        cur.add(nums[currentIndex]);
        findTargetSum(nums,target - nums[currentIndex], cur,currentIndex);
        cur.remove(cur.size()-1);
        findTargetSum(nums,target, cur,currentIndex+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        findTargetSum(nums,target,cur,0);
        return result;

    }
}
