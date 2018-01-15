package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2018/1/15.
 */
public class Java_96 {

    public List<Integer> spiralOrder(int[][] matrix) {      //螺旋打印矩阵中的数字
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if(row==0)
            return res;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        if(col!=0) {
            visited[0][0] = true;
            res.add(matrix[0][0]);
        }
        int direction = 0;		//0右，1下，2左，3上
        int k=1;
        int i=0,j=0;
        while(k<row*col){
            if(direction==0){
                while(j<col-1 && !visited[i][j+1]){
                    visited[i][j+1] = true;
                    res.add(matrix[i][++j]);
                    k++;
                }
                direction =1;
            }else if(direction ==1){		//下
                while(i<row-1 && !visited[i+1][j]){
                    visited[i+1][j] = true;
                    res.add(matrix[++i][j]);
                    k++;
                }
                direction =2;
            }else if(direction==2){
                while(j>0 && !visited[i][j-1]){
                    visited[i][j-1] = true;
                    res.add(matrix[i][--j]);
                    k++;
                }
                direction =3;
            }else{
                while(i>0 && !visited[i-1][j]){
                    visited[i-1][j] = true;
                    res.add(matrix[--i][j]);
                    k++;
                }
                direction =0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Java_96 a = new Java_96();
        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        a.spiralOrder(b);
    }
}
