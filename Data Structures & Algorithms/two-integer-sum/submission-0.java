class Solution {
    public int[] twoSum(int[] nums, int target) {
        // We create a hashmap where the key will target - num value and the value will be index of num value
        Map<Integer, Integer> map = new HashMap<>();
        //We loop over the nums array and check if num exists in the hashmap
        for(int i = 0; i < nums.length; i++) {
            //If it does then it means we have its complimentary number the sum of whom with num will be equal to target
            // we return the index of both of them
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        
        //else we return -1, -1
        return new int[]{-1, -1};
    }
}
