package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/8.
 */
public class Java_83 {

    /**至多只能一个小数点和e，e后面不能有小数点
     * 第一位或最后一位可以为小数点
     * +/-只能出现在第一位或者e后面的第一位
    */
    public boolean isNumber(String s) {     //判断一个字符串是不是合法的数字
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean isNumber = false;

        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp>='0' && temp<='9'){
                isNumber = true;
            }else if(temp == '.'){
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }else if(temp == 'e'){
                if(eSeen || !isNumber)
                    return false;
                eSeen = true;
                isNumber = false;
            }else if(temp == '+' || temp=='-'){     //只能在首位或者isNumber后面为+/-
                if(i!=0 && s.charAt(i-1)!='e' )
                    return false;
                isNumber = false;
            }else
                return false;
        }

        return isNumber;
    }

    public static void main(String[] args) {
        Java_83 a = new Java_83();
        System.out.println(a.isNumber("3.5e+3"));
    }
}
