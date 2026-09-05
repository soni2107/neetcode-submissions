class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    public void sum(int[] nums, int target, int runningSum, int index, 
        List<List<Integer>> result, List<Integer> list) {
        if(runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        else if(runningSum > target || index == nums.length) {
            return;
        }

        list.add(nums[index]);
        sum(nums, target, runningSum + nums[index], index + 1, result, list);
        list.remove(list.size() - 1);
        while(index < nums.length - 1 && nums[index] == nums[index + 1])
            index++;
        sum(nums, target, runningSum, index + 1, result, list);
    }
}
