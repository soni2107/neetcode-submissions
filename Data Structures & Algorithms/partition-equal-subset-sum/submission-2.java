class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums) {
            target += num;
        }
        
        if(target % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[nums.length][target/2 + 1];
        return sum(nums, target/2, 0, dp);
    }

    public boolean sum(int[] nums, int target, int index, Boolean[][] dp) {
        if(index == nums.length)
            return target == 0;
        else if(target < 0)
            return false;
        
        if(null != dp[index][target])
            return dp[index][target];
        
        dp[index][target] = sum(nums, target, index + 1, dp) || sum(nums, target - nums[index], index + 1, dp);
        return dp[index][target];
    }
}
