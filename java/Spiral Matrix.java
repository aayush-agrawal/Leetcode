class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int start_row = 0;
        int end_row = matrix.length-1;
        int start_col = 0;
        int end_col = matrix[0].length-1;
        
        List<Integer> result = new ArrayList<>();
        while(start_row <= end_row && start_col<=end_col) {
            for(int col=start_col; col<=end_col; col++) 
                result.add(matrix[start_row][col]);
                
            for(int row=start_row+1; row<=end_row; row++) 
                result.add(matrix[row][end_col]);
                
            for(int col=end_col-1; col>=start_col; col--) {
                if(start_row == end_row)
                    break;
                result.add(matrix[end_row][col]);
            }
            
            for(int row=end_row-1; row>=start_row+1; row--) {
                if(start_col == end_col)
                    break;
                result.add(matrix[row][start_col]);
            }
            
            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }
        
        return result;
    }
}