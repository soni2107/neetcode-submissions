class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void findSubset(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
        //iterate over the length of nums
        //at index j , add the num to list
        // call subset method again with j+1
        //once it reaches maximum length add to list
        if(i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(Integer.valueOf(nums[i]));
        findSubset(nums, i + 1, result, list);
        list.remove(list.size() - 1);
        findSubset(nums, i + 1, result, list);
    }
}
