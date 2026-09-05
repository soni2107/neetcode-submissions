class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while(leftPointer < rightPointer) {
            int leftPointerVal = numbers[leftPointer];
            int rightPointerVal = numbers[rightPointer];
            if(leftPointerVal + rightPointerVal > target)
                rightPointer--;
            else if(leftPointerVal + rightPointerVal < target)
                leftPointer++;
            else if(leftPointerVal + rightPointerVal == target)
                break;
        }
        return new int[]{leftPointer + 1, rightPointer + 1};
    }


}
