package SwordToOffer;

import java.util.Arrays;

/**
 * Created by LXY on 2017/9/24.
 */
public class MoreThanHalfNum_Solution_28 {

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution(int [] array) {

        //方法一：用一个map记录，然后遍历map判断,略。
        //方法二：排序，然后遍历数组
        if(array.length ==1) return 1;
        Arrays.sort(array);
        int nowCount = 1;       //记录连续相同数的个数
        int length = array.length;
        for(int i=1;i<length;i++){
            if(array[i]!=array[i-1]){
                if(nowCount>length/2){
                    return array[i-1];
                }else{
                    nowCount = 1;       //重置为1
                }
            }else{
                nowCount++;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        MoreThanHalfNum_Solution_28 moreThanHalfNum_solution_28 = new MoreThanHalfNum_Solution_28();
        int [] array = {1,2,3,2,2,2,5,4,2};
        int a = moreThanHalfNum_solution_28.MoreThanHalfNum_Solution(array);
        System.out.println(a);
    }
}
