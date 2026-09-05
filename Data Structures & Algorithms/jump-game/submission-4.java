class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jump(nums, 0, dp);
    }

    public boolean jump(int[] nums, int index, int[] dp) {
        if(index == nums.length - 1)
            return true;

        if(dp[index] != -1)
            return dp[index] == 1 ? true : false;
        boolean result = false;
        for(int i = 1; i <= nums[index]; i++) {
            result = jump(nums, index + i, dp);
            if(result) {
                dp[index] = 1;
                return result;
            }
                
        }
        dp[index] = 0;
        return false;
    }
}
