package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/12/4.
 */
public class Java_56 {   //restore-ip-addresses，复原ip地址

    //对于一个ip地址，分为四段，每段最多为三位，最少为一位，每段都在0-255之间.用一个整数start记录当前的段数，当第三段完之后，只需要判断第四段是否合法即可
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length()<4 || s.length() >12)
            return list;

        dfs(s,0,"",list);
        return list;
    }

    private void dfs(String s,int start,String res,List<String> list){
        if(start >3) return;
        if(start == 3 && isValid(s)){
            list.add(res + s);
            return;
        }

        for(int i=0;i<3 && i<s.length();i++){       //这里记得还要判断不能超出字符串范围
            String sub = s.substring(0,i+1);
            if(isValid(sub))
                dfs(s.substring(i+1,s.length()),start+1,res + sub + ".",list);
        }
    }

    private boolean isValid(String s){          //判断字符串是否合法，如果第一个字符为'0'，需要判断是否全为0;如果第一个字符不为'0'，判断是否在0-255之间
        if(s.length()==0) return false;
        if(s.charAt(0)=='0')
            return s.equals("0");
        if(Integer.parseInt(s)<=255 && Integer.parseInt(s)>0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Java_56 a = new Java_56();
        a.restoreIpAddresses("1111");
    }
}
