class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) return 0;
        
        int numofIslands = 0;
        for(int i = 0;i<grid.length;i++) {
            for(int j = 0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                numofIslands = numofIslands + bfs(grid, i, j);
                }
            }
        }
        return numofIslands;
    }
    
    int bfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        
        grid[i][j] = '0';
        bfs(grid, i-1, j);
        bfs(grid, i+1, j);
        bfs(grid, i, j-1);
        bfs(grid, i, j+1);
        return 1;
    }
}