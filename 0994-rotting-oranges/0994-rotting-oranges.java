class Solution {
    public int orangesRotting(int[][] grid) {
       if(grid==null || grid.length==0) return 0;
        int rows=grid.length;
        int columns=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int count_fresh=0;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(grid[i][j]==2) {
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]!=0) {
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh==0) return 0;
        int countmin=0, count=0;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        while(!queue.isEmpty()) {
            int size=queue.size();
            count=count+size;
            for(int i=0;i<size;i++) {
                int[] point=queue.poll();
                for(int j=0;j<4;j++) {
                    int x=point[0] + dx[j];
                    int y=point[1] + dy[j];
                    
                    if(x<0 || y<0 || x>=rows || y>=columns || grid[x][y]==0 || grid[x][y]==2) continue;
                    
                    grid[x][y]=2;
                    queue.offer(new int[]{x,y});
                }
            }
            if(queue.size()!=0) {
                countmin++;
            }
        }
        return count_fresh==count ? countmin : -1;
    }
}