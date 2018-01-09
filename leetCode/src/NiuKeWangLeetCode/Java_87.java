package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/9.
 */
public class Java_87 {


    public int uniquePaths(int m, int n) {      //二维矩阵从左上角都右下角的方式，每次只能向下或者向右移动一格
        int A[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0 || j==0){
                    A[i][j] = 1;
                }else
                    A[i][j] = A[i-1][j] + A[i][j-1];
            }
        }

        return A[m-1][n-1];
    }
}
