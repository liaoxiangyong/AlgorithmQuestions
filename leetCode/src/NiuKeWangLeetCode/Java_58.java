package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by LXY on 2017/12/7.
 */
public class Java_58 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {        //给出一个可能包含重复值的集合，求出该集合的所有子集
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        Arrays.sort(num);       //按升序排列
        countDup(result,arrayList,num,0);
        return result;
    }

    public void countDup(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arrayList,int[] num,int start){
        result.add(new ArrayList<>(arrayList));
        for(int i=start;i<num.length;i++){
            if(i>0 && num[i] == num[i-1]) continue;
            arrayList.add(num[i]);
            countDup(result, arrayList, num, i+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    public static void main(String[] args) {
        Java_58 a = new Java_58();
        int[] num = {1,2,3,3};
        a.subsetsWithDup(num);
    }
}
