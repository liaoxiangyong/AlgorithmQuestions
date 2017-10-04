package SwordToOffer;

/**
 * Created by LXY on 2017/9/28.
 */
public class StrToInt_49 {

    //将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0,输入一个字符串,包括数字字母符号,可以为空
    //输出描述:
    //如果是合法的数值表达则返回该数字，否则返回0
    public int StrToInt(String str) {
        String newStr = str.trim();     //去掉前后空格
        long result = 0;

        if(newStr == null || newStr.length()==0) return 0;
        if(newStr.length() == 1){
            if(newStr.charAt(0)=='+'|| newStr.charAt(0)=='-') return 0;
            if( Character.isDigit(newStr.charAt(0))) return (newStr.charAt(0)-'0');
            else return 0;
        }

        if(newStr.charAt(0)=='+' || Character.isDigit(newStr.charAt(0))){       //第一位是"+"或者直接输数字
            if(Character.isDigit(newStr.charAt(0)))
                result = newStr.charAt(0) - '0';
            for(int i = 1;i<newStr.length();i++){
                if(!Character.isDigit(newStr.charAt(i)))
                    return 0;
                result = result*10 + (newStr.charAt(i)-'0');
                if(result > Integer.MAX_VALUE) return 0;
            }
            return (int)result;
        }else if(newStr.charAt(0)=='-'){
            for(int i = 1;i<newStr.length();i++){
                if(!Character.isDigit(newStr.charAt(i)))
                    return 0;
                result = result*10 + (newStr.charAt(i)-'0');
                if(-result < Integer.MIN_VALUE) return 0;
            }
            return (int)-result;
        }else{
            return 0;
        }

    }

    public static void main(String[] args){
        StrToInt_49 a = new StrToInt_49();
        System.out.println(a.StrToInt("484"));
    }
}
