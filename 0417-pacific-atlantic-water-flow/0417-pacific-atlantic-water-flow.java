class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        for(int i = 0 ; i < col ; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i = 0 ; i < row ; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col-1 , Integer.MIN_VALUE, atlantic);
        }
        
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(pacific[i][j] == true && atlantic[i][j] == true) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
        
        public void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] ocean) {
            if(row < 0 || row >= ocean.length || col < 0 || col >= ocean[0].length || heights[row][col] < prevHeight || ocean[row][col] == true) {
                return;
            }
            
            ocean[row][col] = true;
            dfs(heights, row+1, col, heights[row][col], ocean);
            dfs(heights, row-1, col, heights[row][col], ocean);
            dfs(heights, row, col+1, heights[row][col], ocean);
            dfs(heights, row, col-1, heights[row][col], ocean);
        }
}