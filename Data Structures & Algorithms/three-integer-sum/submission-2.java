class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        //loop over the array with 3 nested loops and find the indices i, j and k such that
        // the sum of their respective values is 0
        //Check for duplicate results
        //-4, -1, -1, 0, 1, 2
        for(int i = 0; i < nums.length; i++) {
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;
            while(leftPointer < rightPointer) {
                if(nums[i] + nums[leftPointer] + nums[rightPointer] > 0)
                    rightPointer--;
                else if(nums[i] + nums[leftPointer] + nums[rightPointer] == 0) {
                    List<Integer> list = List.of(nums[i], nums[leftPointer], nums[rightPointer]);
                    leftPointer++;
                    rightPointer--;
                    result.add(list);
                }
                else if(nums[i] + nums[leftPointer] + nums[rightPointer] < 0)
                    leftPointer++;
                else {
                    leftPointer++;
                    rightPointer--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
