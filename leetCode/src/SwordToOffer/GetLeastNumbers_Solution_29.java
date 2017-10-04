package SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by LXY on 2017/9/24.
 */
public class GetLeastNumbers_Solution_29 {
    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length) return result;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args){
        GetLeastNumbers_Solution_29 moreThanHalfNum_solution_28 = new GetLeastNumbers_Solution_29();
        int [] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = moreThanHalfNum_solution_28.GetLeastNumbers_Solution(array,4);
        System.out.println();
    }
}
