package SwordToOffer;

/**
 * Created by LXY on 2017/10/1.
 */
public class MovingCount_66 {

    //地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
    public int movingCount(int threshold, int rows, int cols) {
        if(rows<0 || cols <0 || threshold<0) return 0;
        boolean[][] visited= new boolean[rows][cols];
        findCount(threshold,rows,cols,0,0,visited);
        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(visited[i][j]) count++;
            }
        }
        return count;
    }

    private void findCount(int threshold, int rows, int cols,int i,int j,boolean[][] visited){
        if(visited[i][j]==true) return;
        visited[i][j]=true;     //置为访问过
        //上
        if(i>0 && (getSum(i-1)+getSum(j))<=threshold){
            findCount(threshold,rows,cols,i-1,j,visited);
        }

        //下
        if(i<rows-1 && (getSum(i+1)+getSum(j))<=threshold){
            findCount(threshold,rows,cols,i+1,j,visited);
        }

        //左
        if(j>0 && (getSum(i)+getSum(j-1))<=threshold){
            findCount(threshold,rows,cols,i,j-1,visited);
        }

        //右
        if(j<cols-1 && (getSum(i)+getSum(j+1))<=threshold){
            findCount(threshold,rows,cols,i,j+1,visited);
        }
    }

    private int getSum(int n){     //计算一个数字的各位数字之和
        int sum = 0;
        while(n/10>0){
            sum += n%10;
            n = n/10;
        }
        sum +=n;
        return sum;
    }

    public static void main(String[] args) {
        MovingCount_66 a = new MovingCount_66();
        System.out.println(a.getSum(20));
//        System.out.println(a.movingCount(15,20,20));
    }
}
