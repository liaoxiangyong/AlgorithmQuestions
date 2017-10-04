package SwordToOffer;

/**
 * Created by LXY on 2017/9/26.
 */
public class LeftRotateString_43 {

    //汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
    public String leftRotateString(String str,int n) {

        int length = str.length();
        char[] chars = new char[length];
        for(int i=0; i<length;i++){
            int newIndex = i - n%length;
            if(newIndex < 0)
                newIndex = length + newIndex;
            chars[newIndex] = str.charAt(i);
        }
        return  String.valueOf(chars);
    }

    public static void main(String[] args){
        System.out.println(new LeftRotateString_43().leftRotateString("abcXYZdef",11));
    }

}
