package NiuKeWangLeetCode;

import java.util.ArrayList;

/**
 * Created by LXY on 2018/1/10.
 */
public class Java_90 {

    public String getPermutation(int n, int k) {        //n为长度的字符串有n！个，求出按照排序后的第k个字符串
        //找规律，可以发现k/（n-1）！就是滴k个序列的最高位在n中年的位置
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        if(n==0) return res.toString();

        int factor = 1;
        for(int i=2;i<n;i++){
            factor *= i;
        }
        for(int i=1;i<=n;i++){
            nums.add(i);
        }

        k = k-1; ;//num的坐标从0开始的
        for(int i=n-1; i>0; i--) {
            int index = k / factor;
            k = k%factor;
            factor = factor/i;
            res.append(nums.get(index));
            nums.remove(index);
        }
        res.append(nums.get(0));
        return res.toString();
    }

    public static void main(String[] args) {
        Java_90 a = new Java_90();
        a.getPermutation(3,3);
    }
}
