class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        subsets(nums, index + 1, result, list);
        list.remove(list.size() - 1);
        while(index < nums.length - 1 && nums[index + 1] == nums[index])
            index++;
        subsets(nums, index + 1, result, list);
    }
}
