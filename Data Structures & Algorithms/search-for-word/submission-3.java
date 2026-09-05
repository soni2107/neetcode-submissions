class Solution {
    public boolean exist(char[][] board, String word) {
        //go through the array to find the first letter
        // once you do, find the next neighboring index which matches the next char
        // keep doing it until you find the word
        //else try again
        char c = word.charAt(0);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(c == board[i][j]) {
                    List<String> visitedIndex = new ArrayList<>();
                    visitedIndex.add(i + "," + j);
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    if(find(board, i, j, word, 0, visitedIndex, sb))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int rowId, int columnId, String word, int charIndex, List<String> visitedIndex, StringBuilder sb) {
        if(board[rowId][columnId] != word.charAt(charIndex))
            return false;
        if(sb.toString().equals(word))
            return true;

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        if(rowId - 1 >= 0 && !visitedIndex.contains((rowId - 1) + "," + columnId)) {
            visitedIndex.add((rowId - 1) + "," + columnId);
            b1 = find(board, rowId - 1, columnId, word, charIndex + 1, visitedIndex, sb.append(board[rowId - 1][columnId]));
            visitedIndex.remove(visitedIndex.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rowId + 1 < board.length && !visitedIndex.contains((rowId + 1) + "," + columnId)) {
            visitedIndex.add((rowId + 1) + "," + columnId);
            b2 = find(board, rowId + 1, columnId, word, charIndex + 1, visitedIndex, sb.append(board[rowId + 1][columnId]));
            visitedIndex.remove(visitedIndex.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(columnId - 1 >= 0 && !visitedIndex.contains(rowId + "," + (columnId - 1))) {
            visitedIndex.add(rowId + "," + (columnId - 1));
            b3 = find(board, rowId, columnId - 1, word, charIndex + 1, visitedIndex, sb.append(board[rowId][columnId - 1]));
            visitedIndex.remove(visitedIndex.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(columnId + 1 < board[0].length && !visitedIndex.contains(rowId + "," + (columnId + 1))) {
            visitedIndex.add(rowId+ "," + (columnId + 1));
            b4 = find(board, rowId, columnId + 1, word, charIndex + 1, visitedIndex, sb.append(board[rowId][columnId + 1]));
            visitedIndex.remove(visitedIndex.size() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return b1 || b2 || b3 || b4;
    }
}
