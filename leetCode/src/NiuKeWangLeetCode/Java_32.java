package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/11/10.
 */
public class Java_32 {
    public List<Integer> getRow(int rowIndex) {     //获取第杨辉三角的第rowIndex行，空间复杂度为o(rowIndex)
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){       //分别求出每一行
            list.add(1);
            for(int k=i-1;k>0;k--){
                list.set(k,list.get(k)+list.get(k-1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Java_32 a = new Java_32();
        a.getRow(5);
    }
}
