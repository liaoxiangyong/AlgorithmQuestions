package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LXY on 2017/9/26.
 */
public class FindNumbersWithSum_42 {
    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。对应每个测试案例，输出两个数，小的先输出。


    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {       //双指针了
        ArrayList<Integer> arrayList = new ArrayList<>();

        HashMap<Long,ArrayList> hashMap = new HashMap<>();

        int low = 0;
        int high = array.length-1;
        long minMul = Long.MAX_VALUE;

        int tempMul = 0;
        while(low < high){
            if(low>0&&array[low]==array[low-1]) low++;
            if(high>0&&array[high]==array[high-1]) high--;
            tempMul = array[low] + array[high];
            if(tempMul>sum){
                high--;
            }else if(tempMul<sum){
                low++;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(array[low]);
                list.add(array[high]);
                long mul = array[low]*array[high];
                if(mul<minMul)
                    minMul = mul;
                hashMap.put(mul,list);
                low++;
            }
        }

        if(hashMap.size()==0) return arrayList;
        arrayList = hashMap.get(minMul);
        return arrayList;
    }

    public static void main(String[] args){
        FindNumbersWithSum_42 a = new FindNumbersWithSum_42();
        int[] x = {2,4,5,10,20,20,25,50,75,80};
        ArrayList<Integer> b = a.findNumbersWithSum(x,100);
    }
}
