package NiuKeWangLeetCode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/11/9.
 */
public class Java_31 {


    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] minValue = new int[triangle.size()+1];      //记录每一层的每个点能得到的最小值
        for(int i = triangle.size()-1;i>=0;i--){
            ArrayList<Integer> arrayList = triangle.get(i);
            for(int j=0;j<arrayList.size();j++){
                minValue[j] = Math.min(minValue[j]+arrayList.get(j),minValue[j+1]+arrayList.get(j));
            }
        }
        return minValue[0];
    }

    public static void main(String[] args) {
//        Java_31 a = new Java_31();
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add()
//        System.out.println(a.minimumTotal());
    }
}
