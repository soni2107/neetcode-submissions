class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROW = grid.length;
        int COLUMN = grid[0].length;
        boolean hasFreshFruit = false;
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if(!hasFreshFruit && grid[i][j] == 1)
                    hasFreshFruit = true;
            }
        }

        if(queue.isEmpty() && hasFreshFruit)
            return -1;
        else if(queue.isEmpty())
            return 0;
        
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int size = 0;
        int counter = 0;
        while(!queue.isEmpty()) {
            if(size > 0) {
                size -= 1;
            }
            else {
                size = queue.size() - 1;
                counter++;
            }
            int[] pair = queue.poll();
            int row = pair[0];
            int column = pair[1];
            
            
            for(int i = 0; i < directions.length; i++) {
                int newRow = row + directions[i][0];
                int newColumn = column + directions[i][1];

                if(newRow < 0 || newRow >= ROW || newColumn < 0 || newColumn >= COLUMN || grid[newRow][newColumn] != 1)
                    continue;
                
                grid[newRow][newColumn] += 1;
                queue.add(new int[]{newRow, newColumn});
            }
        }

        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return counter - 1;
    }
}
