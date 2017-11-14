package NiuKeWangLeetCode;

import java.util.HashMap;

/**
 * Created by LXY on 2017/11/13.
 */
public class Java_add_1 {  //最小子串覆盖问题,记录每个字符出现次数，然后查找

    public String minWindow(String source , String target) {
        // write your code here
        int[] srcHash = new int[255];
        //记录目标字符串每个字母出现次数
        for(int i=0;i<target.length();i++){
            srcHash[target.charAt(i)]++;
        }
        int start = 0,i=0,found =0;
        int[] dectHash = new int[255];

        int begin = -1,end =source.length(),minLength = source.length();
        for(start = i=0;i<source.length();i++){
            dectHash[source.charAt(i)] ++;
            if(dectHash[source.charAt(i)]<=srcHash[source.charAt(i)]) found++;       //若没有到数，添加1

            if(found == target.length()){       //找到了能包含target的字符串，然后去掉前面的无用字符串
                while(start < i && dectHash[source.charAt(start)]>srcHash[source.charAt(start)]){
                    dectHash[source.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i-start < minLength){
                    minLength = i-start;
                    begin = start;
                    end = i;
                }
                //从下一个字符串开始查找
                dectHash[source.charAt(start)]--;
                found--;
                start++;
            }
        }
        return begin==-1?"":source.substring(begin,end+1);
    }

    public static void main(String[] args) {
        Java_add_1 a = new Java_add_1();
        System.out.println();a.minWindow("abc","a");
    }
}
