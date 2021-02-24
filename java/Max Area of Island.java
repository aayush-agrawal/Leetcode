class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    result = Math.max(result, bfs(grid, queue, visited));                    
                }
            }
        }
        
        return result;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            result++;
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if (r < 0 || r >= m || c < 0 || c >=n || visited[r][c] || grid[r][c] == 0) 
                    continue;
                
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
        return result;
    }
}