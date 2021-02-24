class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1)
                    return bfs(i,j,grid, visited);
            }
        }
        
        return -1;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int bfs(int i, int j, int[][] grid, boolean[][] visited) {
        
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] src  = queue.poll();
            int x = src[0];
            int y = src[1];
            result += 4;
            if(x>0 && grid[x-1][y] == 1) //up
                result--;
            
            if(x<grid.length-1 && grid[x+1][y] == 1) //down
                result--;
            
            if(y>0 && grid[x][y-1] == 1) //left
                result--;
            
            if(y<grid[0].length-1 && grid[x][y+1] == 1) //right
                result--;
            
            for(int[] dir: dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX<0 || newX>grid.length-1 
                   || newY<0 || newY>grid[0].length-1 
                   || grid[newX][newY] == 0 
                   || visited[newX][newY] == true)
                    continue;
                
                visited[newX][newY] = true;
                queue.offer(new int[] {newX, newY});
            }
        }
        return result;
    }
}