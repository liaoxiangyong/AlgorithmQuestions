package SwordToOffer;

/**
 * Created by LXY on 2017/9/28.
 */
public class Match_52 {

    //请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) return false;

        int strIndex = 0;
        int patIndex = 0;

        return matchCore(str,strIndex,pattern,patIndex);
    }

    public boolean matchCore(char[] str,int strIndex,char[] pattern,int patIndex){
        if (strIndex == str.length && patIndex == pattern.length) {         //都到了尾部
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patIndex == pattern.length) {
            return false;
        }
        if(patIndex<pattern.length-1&&pattern[patIndex+1]=='*'){        //后面一个字符为*，即p*或者.*格式
            if((strIndex != str.length && pattern[patIndex] == str[strIndex])|| (strIndex != str.length && pattern[patIndex]=='.')){
                return matchCore(str, strIndex, pattern, patIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patIndex);//*匹配1个，再匹配str中的下一个
            }else {     //无匹配，pattern直接跳到*后面的字符
                return matchCore(str, strIndex, pattern, patIndex + 2);
            }
        }

        //不为最后一个字符，且字符相等或者为'.'，都向后移动一位
        if((strIndex != str.length && pattern[patIndex] == str[strIndex])||((pattern[patIndex] == '.' && strIndex != str.length))){
            return matchCore(str,strIndex+1,pattern,patIndex+1);
        }
        return false;
    }

    public static void main(String[] args){
        Match_52 a = new Match_52();
        char[] str = "asbcd".toCharArray();
        char[] pattern = ".*".toCharArray();
        System.out.println(a.match(str,pattern));
    }
}
