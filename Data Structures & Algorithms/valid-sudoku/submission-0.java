class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        List<List<Set<Character>>> gridSetList = getGridSet();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int gridRow = i / 3;
                int gridColumn = j / 3;
                Set<Character> gridSet = gridSetList.get(gridRow).get(gridColumn);
                if(board[i][j] != '.') {
                    if(!rowSet.add(board[i][j]))
                        return false;
                    if(!gridSet.add(board[i][j]))
                        return false;
                }
                if(board[j][i] != '.') {
                    if(!columnSet.add(board[j][i]))
                        return false;
                }

            }
            rowSet = new HashSet<>();
            columnSet = new HashSet<>();
        }

        return true;
    }

    public List<List<Set<Character>>> getGridSet() {
        List<List<Set<Character>>> gridSet = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            List<Set<Character>> row = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                row.add(new HashSet<>());
            }
            gridSet.add(row);
        }
        return gridSet;
    }
}
