package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/9.
 */
public class Java_88 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row ==0) return 0;
        int col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(obstacleGrid[i][j]==1) {
                    res[i][j] = 0;
                    continue;
                }
                if(i==0 || j==0){
                    if(j!=0){
                        res[i][j] =  res[i][j-1];
                    }else if(i!=0){
                        res[i][j] =  res[i-1][j];
                    }else{
                        res[i][j] =  1;
                    }
                }else{
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] ob = {{0,0,0},{0,0,0},{0,0,0}};
        Java_88 a = new Java_88();
        a.uniquePathsWithObstacles(ob);
    }
}
