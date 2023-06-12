class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        //create a empty chessboard
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> result=new ArrayList<>();
        int[] leftrow=new int[n];
        int[] lowerdiagonal=new int[2*n-1];
        int[] upperdiagonal=new int[2*n-1];
        backtrack(0, board, result, leftrow, lowerdiagonal, upperdiagonal);
        return result;
    }

    void backtrack(int col, char[][] board, List<List<String>> result, int[] leftrow, int[] lowerdiagonal, int[] upperdiagonal) {
        if(col==board.length) {
            result.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++) {
            if(leftrow[row]==0 && lowerdiagonal[row+col]==0 && upperdiagonal[board.length-1 + (col-row)]==0) {
               
                //put the queen
                board[row][col]='Q';
                leftrow[row]=1;
                lowerdiagonal[row+col]=1;
                upperdiagonal[board.length-1 + (col-row)]=1;
                
                //call the recursion 
                backtrack(col+1, board, result, leftrow, lowerdiagonal, upperdiagonal);
                
                //backtracking part
                board[row][col]='.';
                leftrow[row]=0;
                lowerdiagonal[row+col]=0;
                upperdiagonal[board.length-1 + (col-row)]=0;
            }
        }
    }

    List<String> construct(char[][] board) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            String s=new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}