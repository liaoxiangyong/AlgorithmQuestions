package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/15.
 */
public class Java_91 {

    public int[][] generateMatrix(int n) {      //在矩阵中螺旋打印数字
        int[][] res = new int[n][n];
        if(n==0) return res;
        int k = 1;
        res[0][0] = 1;
        generate(res,k,n,0,0,0);
        return res;
    }


    private void generate(int[][] res,int k,int n,int i,int j,int direction){     //0代表右，1代表下，2代表左，3代表上
        while(k<n*n){
            if(direction == 0){ //右
                while(j<n-1 && res[i][j+1]==0){
                    res[i][j+1] = ++k;
                    j++;
                }
                direction = 1;
            }else if(direction==1){     //下
                while(i<n-1 && res[i+1][j]==0){
                    res[i+1][j] = ++k;
                    i++;
                }
                direction = 2;
            }else if(direction==2){
                while(j>0 && res[i][j-1]==0){
                    res[i][j-1] = ++k;
                    j--;
                }
                direction = 3;
            }else{
                while(i>0 && res[i-1][j]==0){
                    res[i-1][j] = ++k;
                    i--;
                }
                direction = 0;
            }
        }
    }

    public static void main(String[] args) {
        Java_91 a = new Java_91();
        a.generateMatrix(4);
    }
}
