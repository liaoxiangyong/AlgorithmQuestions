package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2018/1/23.
 */
public class Java_99 {

    public int totalNQueens(int n) {
        int[] res = new int[1];
        char[][] matrix = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                matrix[i][j] = '.';
        }
        backtracking(res,matrix,0,n);
        return res[0];
    }

    private void backtracking(int[] res,char[][] matrix,int i,int n){
        if(i==n-1){
            for(int j=0;j<n;j++){
                if(isValid(matrix,i,j,n)){        //合法的皇后
                    res[0]++;
                }
            }
            return;
        }
        for(int j=0;j<n;j++){
            if(isValid(matrix,i,j,n)){
                matrix[i][j] = 'Q';
                backtracking(res,matrix,i+1,n);
                matrix[i][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] matrix,int i,int j,int n){
        boolean res = true;
        //只对i上面的行检查，判断是否在一列或者在一条斜线上
        int up = i-1;
        while(up>=0){
            if(matrix[up][j]=='Q') return false;
            up--;
        }
        //左上
        int left = j-1,upleft = i-1;
        while(left>=0 && upleft>=0){
            if(matrix[upleft--][left--]=='Q') return false;
        }
        //右上
        int right = j+1,upRight = i-1;
        while(right<n && upRight>=0){
            if(matrix[upRight--][right++]=='Q') return false;
        }
        return res;
    }
}
