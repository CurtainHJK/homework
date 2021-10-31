class Solution {
    int col;
    int row;
    char [][]board;
    public void solve(char[][] board) {
        this.board=board;
        row=board.length;
        col=board[0].length;
        //第一行和最后一行做DFS
        for(int i=0;i<row;i++){    
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        //第一列和最后一列做DFS
        for(int j=0;j<col;j++){    
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        //将边界的点和相连的点找出来，进行标记
        for(int i=0;i<row;i++){    
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        return ;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')   //递归终止条件判断
            return;
        board[i][j]='-';    //将当前O更改为-
            dfs(board,i-1,j);   //递归该点上方的点
            dfs(board,i+1,j);   //递归该点下方的点
            dfs(board,i,j-1);   //递归该点左边的点
            dfs(board,i,j+1);   //递归该点右边的点
        return ;
    }
}