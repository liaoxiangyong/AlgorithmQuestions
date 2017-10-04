package SwordToOffer;

/**
 * Created by LXY on 2017/9/18.
 */
public class NumberOf1_11 {

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public static int NumberOf1(int n) {
        if(n==0) return 0;
        String binary = Integer.toBinaryString(n);
        int result = 0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1')
                result++;
        }
        return result;
    }

    public static void main(String[] args){
        NumberOf1(1);
    }
}
