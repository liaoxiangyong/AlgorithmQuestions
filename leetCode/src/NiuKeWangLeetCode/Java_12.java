package NiuKeWangLeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LXY on 2017/10/11.
 */
public class Java_12 {

    //直接用递归会超时，所以这里用dp来求解。能到达字符串当前点的条件为：前面有能到达的字符串+一个字典中的word。
    public boolean wordBreak(String s, Set<String> dict) {
        int length=s.length();
        boolean[] res=new boolean[length+1];	//记录到第0个字符到第i个字符的子字符串能否被字典划分
        res[0]=true;
        for(int i=1;i<=length;i++){
            for(int j=0;j<i;j++){
                if(res[j]&&dict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[length];
    }

    public static void main(String[] args) {
        Java_12 a = new Java_12();
        String[] x = {"leet", "code"};
        Set<String> set = new HashSet<>(Arrays.asList(x));
        System.out.println(a.wordBreak("leetcode",set));
    }
}
