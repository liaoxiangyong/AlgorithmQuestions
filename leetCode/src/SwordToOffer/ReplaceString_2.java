package SwordToOffer;

/**
 * Created by LXY on 2017/9/17.
 */
public class ReplaceString_2 {

    public String replaceSpace(StringBuffer str) {      //j将字符串中的空格替换为%20
        String string = str.toString();
        String result = string.replaceAll(" ","%20");
        return result;
    }

    public static void main(String[] args){
        ReplaceString_2 replaceString_2 =new ReplaceString_2();
        System.out.println(replaceString_2.replaceSpace(new StringBuffer("We are happy")));
    }
}
