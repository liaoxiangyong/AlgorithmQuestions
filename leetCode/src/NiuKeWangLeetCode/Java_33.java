package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/11/10.
 */
public class Java_33 {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {      //产生杨辉三角的前n行
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);  //每行第一个数为1
            ArrayList<Integer> preRowList = new ArrayList<>();  //取出上一行数据
            if(result.size()>1)
                preRowList = result.get(result.size()-1);
            for(int k=1;k<i-1;k++){       //长生每行中间的数
                list.add(preRowList.get(k-1)+preRowList.get(k));
            }
            if(i>=2)      //第二行开始每一行最后都为1
                list.add(1);
            result.add(list);
        }

        return result;
    }
}


