class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int runningProduct = 1;
        for(int i = 0; i < nums.length; i++) {
            prefixProduct[i] = runningProduct;
            runningProduct *= nums[i];
        }

        runningProduct = 1;
        int j = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            suffixProduct[j++] = runningProduct;
            runningProduct *= nums[i];
        }

        //1, 2, 4, 6 -> 1, 1, 2, 8
        //1, 6, 24, 48
        int left = 0;
        int right = nums.length - 1;
        while(left < nums.length && right >= 0) {
            System.out.println(prefixProduct[left] + "|" + suffixProduct[right]);
            result[left] = prefixProduct[left] * suffixProduct[right];
            left++;
            right--;
        }

        return result;
    }
}  
