class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // A very important catch here matrix.length-1->(number of rows) and matrix[0].length-1->(number of coloumns)
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}