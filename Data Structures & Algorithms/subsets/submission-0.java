class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        findSubset(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void findSubset(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
        //iterate over the length of nums
        //at index j , add the num to list
        // call subset method again with j+1
        //once it reaches maximum length add to list
        if(i == nums.length) {
            return;
        }

        for(int j = i; j < nums.length; j++) {
            list.add(Integer.valueOf(nums[j]));
            result.add(new ArrayList<>(list));
            findSubset(nums, j + 1, result, list);
            list.remove(Integer.valueOf(nums[j]));
        }
    }
}
