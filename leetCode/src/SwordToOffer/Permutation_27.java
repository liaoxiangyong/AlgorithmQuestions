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
        ArrayList<String> result = new ArrayList<>();
        if(str.length()==0) return result;

        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
        result = getList(chars);
        Collections.sort(result);
        return result;
    }

    public ArrayList<String> getList(char[] chars){
        if(chars.length==1){
            ArrayList<String> result  = new ArrayList<>();
            result.add(chars[0]+"");
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0;i<chars.length;i++){
            ArrayList<String> pre = new ArrayList<>();
            char[] subChar = new char[chars.length-1];
            for(int m=0;m<chars.length; m++){
                if(m<i){
                    subChar[m] = chars[m];
                }else if(m>i){
                    int x = m-1;
                    subChar[x] = chars[m];
                }
            }
            pre = getList(subChar);
            for(int j=0;j<pre.size();j++){
                if(!result.contains(chars[i]+pre.get(j)))
                    result.add(chars[i]+pre.get(j));
            }
        }
        return result;
    }
    public static void main(String[] args){
        Permutation_27 permutation_27 = new Permutation_27();
        ArrayList<String> a = permutation_27.Permutation("baa");
        System.out.println();
    }
}

