class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++) {
            int remainingDiff = target - nums[i];
            if(map.containsKey(remainingDiff))
                return new int[]{map.get(remainingDiff), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
