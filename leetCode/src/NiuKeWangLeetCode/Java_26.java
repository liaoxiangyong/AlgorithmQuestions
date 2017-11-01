package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/1.
 */
public class Java_26 {

//    public boolean isPalindrome(String s) {  //方法一
//        if(s == null || s.length() == 0 ) return true;
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<s.length();i++){      //取出标点符号，只留下字母和数字
//            char ch = s.charAt(i);
//            if(Character.isLetterOrDigit(ch)){
//                sb.append(ch);
//            }
//        }
//
//        //全部变为小写字母
//        String newStr = sb.toString().toLowerCase();
//        for(int i=0;i<newStr.length()/2;i++){
//            if(newStr.charAt(i)!=newStr.charAt(newStr.length()-1-i))
//                return false;
//        }
//        return true;
//    }
    public boolean isPalindrome(String s) {     //方法二
        if(s == null || s.length() == 0 ) return true;
        int i = 0,j = s.length()-1;
        for(i=0,j=s.length()-1;i<j;++i,--j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(i<j && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Java_26 a = new Java_26();
        System.out.println(a.isPalindrome("0P"));
    }
}
