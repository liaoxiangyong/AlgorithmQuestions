package SwordToOffer;

/**
 * Created by LXY on 2017/9/19.
 */
public class Power_12 {

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    public static double Power(double base, int exponent) {
//        return Math.pow(base,exponent);
        int n=Math.abs(exponent);
        if(n == 0) return 1;
        if(n == 1) return base;

        double res = Power(base,n>>1);
        res *= res;
        if((exponent & 1)==1)
            res *= base;
        if(exponent<0) return 1/res;
        return res;
    }


    public static void main(String[] args){
        System.out.println(Power(11.11,3));
    }
}
