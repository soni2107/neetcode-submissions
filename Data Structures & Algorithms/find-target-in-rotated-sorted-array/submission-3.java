class Solution {
    public int search(int[] nums, int target) {
        int resultIndex = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                resultIndex = mid;
                break;
            }
            else if(target < nums[mid]) {
                if(nums[start] <= nums[mid]) {
                    if(nums[start] > target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                if(nums[start] <= nums[mid])
                    start = mid + 1;
                else {
                    if(nums[end] < target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }

        return resultIndex;
    }
}
