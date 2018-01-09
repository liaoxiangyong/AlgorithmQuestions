package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/9.
 */
public class Java_86 {

    public int minPathSum(int[][] grid) {   //一个二维矩阵，包含非负整数，求从左上角到右下角经历路径的最小和
        int row = grid.length;
        if(row==0) return 0;
        int col = grid[0].length;
        int[][] res =  new int[row][col];       //当前点只能从上面点和左边点到达
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(i==0 || j==0){
                    if(j!=0){       //第一行
                        res[i][j] = res[i][j-1]+ grid[i][j];
                    }else if(i!=0){
                        res[i][j] = res[i-1][j] + grid[i][j];
                    }else{
                        res[i][j] = grid[i][j];
                    }
                }else
                    res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
            }
        }
        return res[row-1][col-1];
    }

    public static void main(String[] args) {
        Java_86 a = new Java_86();
        int[][] grid = {{1,3,5},{1,5,1},{4,2,1}};
        a.minPathSum(grid);
    }
}
