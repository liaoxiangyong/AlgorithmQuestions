package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/12/20.
 */
public class Java_72 {

    public List<List<Integer>> combine(int n, int k) {      //给出整数k和n，1-n中的k个数组成集合，求所有可能的集合
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(res,list,n,k,1);
        return res;
    }

    private void find(List<List<Integer>> res, List<Integer> list,int n,int k,int start){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i= start;i<=n;i++){
            list.add(i);
            find(res,list,n,k-1,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Java_72 a = new Java_72();
        a.combine(4,3);
    }
}


