class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums) {
            target += num;
        }
        
        if(target % 2 != 0)
            return false;
        return sum(nums, target/2, 0);
    }

    public boolean sum(int[] nums, int target, int index) {
        if(target == 0)
            return true;
        else if(target < 0)
            return false;
        else if(index >= nums.length)
            return false;
        
        for(int i = index; i < nums.length; i++) {
            boolean result = sum(nums, target - nums[i], i + 1);
            if(result)
                return result;
        }
        return false;
    }
}
