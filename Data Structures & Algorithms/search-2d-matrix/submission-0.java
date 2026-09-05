class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return targetExists(0, matrix.length - 1, 0, matrix[0].length - 1, matrix, target);
    }

    public boolean targetExists(int startRowIndex, int endRowIndex,
        int startColumnIndex, int endColumnIndex, int[][] matrix, int target) {
        if(startRowIndex > endRowIndex || startColumnIndex > endColumnIndex)
            return false;
        int midRowIndex = (startRowIndex + endRowIndex) / 2;
        int midColumnIndex = (startColumnIndex + endColumnIndex) / 2;
        if(matrix[midRowIndex][midColumnIndex] > target) {
            if(matrix[midRowIndex][startColumnIndex] == target)
                return true;
            else if(matrix[midRowIndex][startColumnIndex] < target)
                return targetExists(startRowIndex, endRowIndex, startColumnIndex, midColumnIndex - 1, matrix, target);
            else
                return targetExists(startRowIndex, midRowIndex - 1, startColumnIndex, endColumnIndex, matrix, target);
        }
        else if(matrix[midRowIndex][midColumnIndex] < target) {
            if(matrix[midRowIndex][endColumnIndex] == target)
                return true;
            else if(matrix[midRowIndex][endColumnIndex] > target)
                return targetExists(startRowIndex, endRowIndex, midColumnIndex + 1, endColumnIndex, matrix, target);
            else
                return targetExists(midRowIndex + 1, endRowIndex, startColumnIndex, endColumnIndex, matrix, target);
        }
        else
            return true;
    }
}
