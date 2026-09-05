class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start <= end) {
            if(nums[start] < nums[end]) {
                min = Math.min(min, nums[start]);
                break;
            }
            
            int mid = (start + end) / 2;
            min = Math.min(min, nums[mid]);
            if(nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return min;
    }
}
