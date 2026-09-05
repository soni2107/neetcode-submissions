class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROW = grid.length;
        int COLUMN = grid[0].length;

        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                if(grid[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        if(queue.isEmpty())
            return;
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        while(!queue.isEmpty()) {
            int[] array = queue.poll();
            int row = array[0];
            int column = array[1];
            
            for(int i = 0; i < directions.length; i++) {
                int newRow = row + directions[i][0];
                int newColumn = column + directions[i][1];

                if(newRow < 0 || newRow >= ROW || newColumn < 0 || newColumn >= COLUMN || grid[newRow][newColumn] != Integer.MAX_VALUE)
                    continue;
                
                grid[newRow][newColumn] = 1 + grid[row][column];
                queue.add(new int[]{newRow, newColumn});
            }
        }
    }
}
