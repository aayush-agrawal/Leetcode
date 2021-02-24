class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if (r < 0 || r >= m || c < 0 || c >=n || visited[r][c] || grid[r][c] == '0') 
                    continue;
                
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
    }
}