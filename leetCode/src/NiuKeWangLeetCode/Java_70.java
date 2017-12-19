package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/19.
 */
public class Java_70 {

    public boolean exist(char[][] board, String word) {     //给出一个字符的二维矩阵，判断是否能找到连续（相邻）的字符组成字符串word
        if(word==null || word.length()==0) return true;
        int x = board.length;
        if(x==0) return false;
        int y = board[0].length;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(word.charAt(0)==board[i][j]){        //进入查找函数
                    boolean[][] visited = new boolean[x][y];        //visited[i][j]代表board[i][j]是否被访问过
                    visited[i][j] = true;
                    boolean res = find(board,word,visited,i,j,0);
                    if(res) return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word,boolean[][] visited,int i,int j,int length){
        if(length == word.length()-1) return true;

        boolean left = false,up=false,down =false,right = false;
        //向上
        if(i>0 && board[i-1][j]==word.charAt(length+1) && !visited[i-1][j]){
            visited[i-1][j] = true;
            up = find(board,word,visited,i-1,j,length+1);
            visited[i-1][j] = false;
        }
        if(up) return true;
        //向下
        if(i<board.length-1 && board[i+1][j]==word.charAt(length+1) && !visited[i+1][j]){
            visited[i+1][j] = true;
            down=find(board,word,visited,i+1,j,length+1);
            visited[i+1][j] = false;
        }
        if(down) return true;
        //向左
        if(j>0 && board[i][j-1]==word.charAt(length+1) && !visited[i][j-1]){
            visited[i][j-1] = true;
            left=find(board,word,visited,i,j-1,length+1);
            visited[i][j-1]= false;
        }
        if(left) return true;
        //向右
        if(j<board[0].length-1 && board[i][j+1]==word.charAt(length+1) && !visited[i][j+1]){
            visited[i][j+1] = true;
            right=find(board,word,visited,i,j+1,length+1);
            visited[i][j+1] = false;
        }
        if(right) return true;
        return false;
    }

    public static void main(String[] args) {
        Java_70 a = new Java_70();
        char[][] boar = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(a.exist(boar,"ABCESEEEFS"));
    }
}
