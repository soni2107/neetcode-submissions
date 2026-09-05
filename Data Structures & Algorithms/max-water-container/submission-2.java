class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int leftP = 0;
        int rightP = heights.length - 1;

        while(leftP < rightP) {
            int minHeight = Math.min(heights[leftP], heights[rightP]);
            int area = (rightP - leftP) * minHeight;
            if(area > maxArea)
                maxArea = area;
            
            if(heights[leftP] < heights[rightP])
                leftP++;
            else
                rightP--;
        }

        return maxArea;
    }
}
