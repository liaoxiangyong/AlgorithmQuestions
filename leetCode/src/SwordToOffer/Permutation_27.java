package SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by LXY on 2017/9/22.
 */
public class Permutation_27 {

    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    //输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chArr = str.toCharArray();
        helper(res,chArr,0);
        Collections.sort(res);
        return res;
    }
    private void helper(ArrayList<String> res,char[] chArr,int i){
        if(i==chArr.length-1){
            String val = String.valueOf(chArr);
            if(!res.contains(val))
                res.add(val);
            return;
        }
        for(int j=i;j<chArr.length;j++){
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            helper(res,chArr,i+1);
            temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
        }
    }
    public static void main(String[] args){
        Permutation_27 permutation_27 = new Permutation_27();
        ArrayList<String> a = permutation_27.Permutation("baa");
        System.out.println();
    }
}

