class Solution {
    public int counter = 0;
    public int numIslands(char[][] grid) {
        findIslands(grid, 0, 0, false);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1')
                    findIslands(grid, i, j, false);
            }
        }
        return counter;
    }

    public void findIslands(char[][] grid, int rowId, int columnId, boolean isIsland) {
        if(rowId == grid.length || columnId == grid[0].length || rowId < 0 || columnId < 0)
            return;
        if(grid[rowId][columnId] == '1') {
            if(!isIsland) {
                counter++;
                isIsland = true;
            }
            grid[rowId][columnId] = '2';
            findIslands(grid, rowId - 1, columnId, isIsland);
            findIslands(grid, rowId + 1, columnId, isIsland);
            findIslands(grid, rowId, columnId + 1, isIsland);
            findIslands(grid, rowId, columnId - 1, isIsland);
        }
    }
}
