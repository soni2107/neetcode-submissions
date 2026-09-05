class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        //loop over the array with 3 nested loops and find the indices i, j and k such that
        // the sum of their respective values is 0
        //Check for duplicate results
        //-4, -1, -1, 0, 1, 2
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = List.of(nums[i], nums[j], nums[k]);
                        if(!result.contains(list))
                            result.add(list);
                    }
                }
            }
        }

        return result;
    }
}
