class Solution {
    public int maxSubArray(int[] nums) {        
        int result = Integer.MIN_VALUE;
        int currMax = nums[0];
        int runningSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(runningSum + nums[i] < 0) {
                runningSum = 0;
                currMax = Math.max(currMax, nums[i]);
                result = Math.max(result, currMax);
                continue;
            }
            runningSum += nums[i];
            currMax = Math.max(currMax, runningSum);
        }
        return Math.max(result, currMax);
    }
}
