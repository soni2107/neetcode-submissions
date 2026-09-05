class Solution {
    
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return calculate(nums, 0, dp);
    }

    public int calculate(int[] nums, int index, int[] dp) {
        if(nums.length - 1 == index)
            return 0;
        
        if(dp[index] != -1)
            return dp[index];

        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[index]; i++) {
            if(index + i >= nums.length) {
                break;
            }
            int temp = calculate(nums, index + i, dp);
            if(temp == Integer.MAX_VALUE) {
                continue;
            }
            else {
                result = Math.min(result, temp + 1);
            }
        }
        dp[index] = result;
        return result;
    }
}
