package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/20.
 */
public class Java_73 {

    public String minWindow(String s, String t) {       //给出两个字符串S和t,求在S中包含t中所有字符的最小子串，如果不存在返回"",要求时间复杂度为o(n)
        if(s.length()==0 || t.length()==0) return "";
        int[] tCount = new int[256];            //用一个数组记录每个字符出现的次数，然后在s中保持一个窗口，记录每个字符出现的次数，直到所有窗口的每个字符出现的次数大于等于t中的个数
        for(int i=0;i<t.length();i++){
            tCount[t.charAt(i)]++;
        }

        int[] sCount = new int[256];
        int begin = 0,i=0;
        int start = -1;
        int end = 0;
        int found = 0;      //用来记录找到字符的长度
        int minLength = s.length();       //记录最小长度
        for(begin =i = 0;i<s.length();i++){
            sCount[s.charAt(i)]++;
            if(sCount[s.charAt(i)]<=tCount[s.charAt(i)]) found++;       //若当前s的窗口中字符次数小于t中次数，那么找到的数+1
            if(found == t.length()){        //代表找到了能包含t的字符串
                //可以去除掉前面的无用子串
                while(begin<i && sCount[s.charAt(begin)]>tCount[s.charAt(begin)]){
                    sCount[s.charAt(begin)]--;
                    begin++;
                }

                //此时当前子串的为最小长度，记录起始点和终止点
                if(i-begin < minLength){
                    minLength = i - begin;
                    start = begin;
                    end = i;
                }

                //从下一个字符串继续查找
                sCount[s.charAt(begin)]--;
                begin++;
                found--;
            }
        }
        return start==-1?"":s.substring(start,end+1);
    }
}
