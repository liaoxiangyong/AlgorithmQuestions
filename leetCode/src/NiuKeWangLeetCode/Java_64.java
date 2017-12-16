package NiuKeWangLeetCode;

import java.util.Stack;

/**
 * Created by LXY on 2017/12/16.
 */
public class Java_64 {

    //https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    public int maximalRectangle(char[][] matrix) {      //给出一个包含0,1的二维矩阵，要求求出只包含1的最大子矩阵。判断能不能在matrix[i][j]及其坐左上角的点形成一个全是1的矩形：若当前点为0，肯定不可以；若当前点不为0，

        int xLength = matrix.length;
        if(xLength==0) return 0;
        int yLength = matrix[0].length;

        int[][]  tempMatrix = new int[xLength][yLength];        //tempMatrix[i][j]代表在在第j列到底i行时连续1的个数
        for(int j=0;j<yLength;j++){
            tempMatrix[0][j] = (matrix[0][j]=='0'?0:1);
        }
        for(int j=0;j<yLength;j++) {
            for(int i=1;i<xLength;i++){
                if(matrix[i][j]=='0')
                    tempMatrix[i][j] = 0;
                else{
                    tempMatrix[i][j] = tempMatrix[i-1][j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<xLength;i++){
            int temp = largestRectangleArea(tempMatrix[i]);
            if(max <temp)
                max = temp;
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {        //如果已知height数组是升序的，应该怎么做？比如1,2,5,7,8那么就是(1*5) vs. (2*4) vs. (5*3) vs. (7*2) vs. (8*1)也就是max(height[i]*(size-i))，使用栈的目的就是构造这样的升序序列，按照以上方法求解。在构造栈的时候保存可能的最大值
        if(heights == null)
            return 0;
        int tempResult = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(heights[0]);
        for(int i=1;i<heights.length;i++){
            if(heights[i]>=stack.peek()){        //升序
                stack.push(heights[i]);
            }else{
                if(!stack.isEmpty()){
                    int count = 0;
                    int min = stack.peek();
                    while(!stack.isEmpty() && stack.peek()>heights[i]){
                        if(stack.peek()<min){
                            min = stack.peek();
                        }
                        stack.pop();
                        count ++;
                        if(tempResult<count*min){
                            tempResult = count*min;
                        }
                    }
                    int j=0;
                    while(j<=count){
                        stack.push(heights[i]);
                        j++;
                    }
                }
            }
        }
        for(int i=heights.length-1;i>=0;i--){
            int x= stack.pop();
            if((heights.length-i)*x>tempResult){
                tempResult =(heights.length-i)*x;
            }
        }
        return tempResult;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Java_64 a = new Java_64();
        a.maximalRectangle(chars);
    }
}
