class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sum(nums, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    //Repition is allowed so we cannot keep incrementing the index

    public void sum(int[] nums, int target, int runningSum, int index, List<List<Integer>> result, List<Integer> list) {
        if(runningSum > target)
            return;
        else if(runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            sum(nums, target, runningSum + nums[i], i, result, list);
            list.remove(list.size() - 1);
        }
    }
}
