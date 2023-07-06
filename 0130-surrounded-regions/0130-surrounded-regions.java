class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // check for 1st row and last row
        for(int i = 0 ; i < cols ; i++) {
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[rows-1][i] == 'O') dfs(board, rows-1, i);
        }
        
        //check for 1st col and last col
        for(int i = 0 ; i < rows ; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][cols-1] == 'O') dfs(board, i, cols-1);
        }
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    
    void dfs(char[][] board, int r, int c) {
        if( r<0 || r>=board.length || c<0 || c>=board[r].length || board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = 'T';
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}