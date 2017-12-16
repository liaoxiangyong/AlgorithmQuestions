package NiuKeWangLeetCode;

import java.util.Stack;

/**
 * Created by LXY on 2017/12/16.
 */
public class Java_65 {


    //方法一：暴力求解，查找查找两个数组成的子数组，作为最左直方和最右直方，然后查找其中最低的直方，得到面积，这样的数组一共有2^n个，查找最低直方为o(n),所以时间复杂度为o(n^3)，会超时，略

    //方法二：可以从每一个直方往两边走，以自己的高度为标准，直到两边低于自己的高度为止，然后用自己的高度乘以两边走的宽度得到矩阵面积。因为对于任意一个bar都计算了以自己为目标高度的最大矩阵，所以最好的结果一定会被取到。每次往两边走的复杂度是O(n)，总共有n个bar，所以时间复杂度是O(n^2),也会超时。。。
    public int largestRectangleArea1(int[] heights) {        //求直方图中最大的矩形面积
        int max = 0;

        for(int i=0;i<heights.length;i++){
            int left = i;
            while(left>=0 && heights[i]<=heights[left]){
                left--;
            }
            int right = i;
            while(right<heights.length && heights[i]<=heights[right]){
                right++;
            }
            int area = heights[i] * (right-left-1);
            if(max <area)
                max = area;
        }
        return max;
    }

    //方法三：
    public int largestRectangleArea(int[] heights) {        //如果已知height数组是升序的，应该怎么做？比如1,2,5,7,8那么就是(1*5) vs. (2*4) vs. (5*3) vs. (7*2) vs. (8*1)也就是max(height[i]*(size-i))，使用栈的目的就是构造这样的升序序列，按照以上方法求解。在构造栈的时候保存可能的最大值
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
        int[] a = {2,1,5,6,2,3};
        Java_65 b =new Java_65();
        b.largestRectangleArea(a);
    }

}
