package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/17.
 */
public class Java_21 {
    //‘O’被'X'包围的参数变成'X'
    public void solve(char[][] board) {

        //直接查找在四条边上的'O'，然后查找和边上'O'相连的'O'，其他的所有为’X‘

        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        boolean[][] isO = new boolean[row][col];
        for(int i=0;i<col;i++){     //最上边行
            if(board[0][i] == 'O'&&!isO[0][i]){
                isO[0][i] = true;
                change(board,isO,0,i,row,col);
            }
        }

        for(int i=0;i<col;i++){     //最下边行
            if(board[row-1][i] == 'O'&&!isO[row-1][i]){
                isO[row-1][i] = true;
                change(board,isO,row-1,i,row,col);
            }
        }

        for(int i=0;i<row;i++){     //最左边列
            if(board[i][0] == 'O'&&!isO[i][0]){
                isO[i][0] = true;
                change(board,isO,i,0,row,col);
            }
        }

        for(int i=0;i<row;i++){     //最右边列
            if(board[i][col-1] == 'O'&&!isO[i][col-1]){
                isO[i][col-1] = true;
                change(board,isO,i,col-1,row,col);
            }
        }
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(isO[i][j])
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    private void change(char[][] board,boolean[][] isO,int i,int j,int row,int col){
        //上下左右查找
        //上
        if(i>0 && board[i-1][j]=='O'&&!isO[i-1][j]){
            isO[i-1][j] = true;
            change(board,isO,i-1,j,row,col);
        }

        //下
        if(i<row-1 && board[i+1][j]=='O'&&!isO[i+1][j]){
            isO[i+1][j] = true;
            change(board,isO,i+1,j,row,col);
        }


        //左
        if(j>0 && board[i][j-1]=='O'&&!isO[i][j-1]){
            isO[i][j-1] = true;
            change(board,isO,i,j-1,row,col);
        }

        //右
        if(j<col-1 && board[i][j+1]=='O'&&!isO[i][j+1]){
            isO[i][j+1] = true;
            change(board,isO,i,j+1,row,col);
        }
    }

    public static void main(String[] args) {
        Java_21 a = new Java_21();
        char[][] b = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','X','O','X'}};
        a.solve(b);
    }
}
