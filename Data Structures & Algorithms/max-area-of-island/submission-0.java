class Solution {
    public int maxArea = 0;
    public int currentArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    calculateArea(grid, i, j, false);
                
                maxArea = Math.max(maxArea, currentArea);
                currentArea = 0;
            }
        }
        return maxArea;
    }

    public void calculateArea(int[][] grid, int rowId, int columnId, boolean isIsland) {
        if(rowId < 0 || rowId == grid.length || columnId < 0 || columnId == grid[0].length || grid[rowId][columnId] == 0)
            return;

        if(!isIsland) {
            isIsland = true;
        }
        currentArea++;
        grid[rowId][columnId] = 0;
        calculateArea(grid, rowId - 1, columnId, isIsland);
        calculateArea(grid, rowId + 1, columnId, isIsland);
        calculateArea(grid, rowId, columnId - 1, isIsland);
        calculateArea(grid, rowId, columnId + 1, isIsland);
    }
}
