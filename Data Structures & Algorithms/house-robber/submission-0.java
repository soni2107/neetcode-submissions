class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return Math.max(maxAmount(nums, 0, memo), maxAmount(nums, 1, memo));
    }

    public int maxAmount(int[] nums, int index, int[] memo) {  
        if(index >= nums.length)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];
        
        memo[index] = nums[index] + Math.max(maxAmount(nums, index + 2, memo),maxAmount(nums, index + 3, memo));
        return memo[index];
    }
}
