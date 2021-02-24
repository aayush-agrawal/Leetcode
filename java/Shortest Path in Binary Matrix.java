class Solution {
    public int shortestPathBinaryMatrix(int[][] matrix) {
     
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
         if(matrix[0][0]==1 || matrix[row-1][col-1]==1) {
            return -1;
        }
        queue.add(new int []{0, 0});
        visited[0][0] = true;
        int [][] directions = new int [][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(x==row-1 && y == col-1)
                return move+1;
            
            for (int [] dir : directions) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                 if(newX>=0 && newX<row && newY>=0 && newY<col && !visited[newX][newY] && matrix[newX][newY]==0) {
                        queue.add(new int[]{newX,newY});
                        visited[newX][newY]=true;
                    }
                }
            }
            move++;
        }
        return -1;
    }
}