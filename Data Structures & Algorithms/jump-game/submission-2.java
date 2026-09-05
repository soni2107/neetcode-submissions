class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2; i >=0; i--) {
            if(i + nums[i] < nums.length - 1)
                for(int j = nums[i]; j >= 0; j--) {
                    dp[i] = dp[i + j];
                    if(dp[i])
                        break;
                }
                
            else
                dp[i] = true;
        }

        return dp[0];
    }
}
