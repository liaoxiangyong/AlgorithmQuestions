package SwordToOffer;

/**
 * Created by LXY on 2017/9/19.
 */
public class Power_12 {

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    public static double Power(double base, int exponent) {
//        return Math.pow(base,exponent);
        if(exponent==0) return 1;
        double result = 1;
        if(exponent>0){
            int i=0;
            while(i<exponent){
                result *= base;
                i++;
            }
            return result;
        }else{
            double temp = 1;
            int i=0;
            while(i<-exponent){
                temp *= base;
                i++;
            }
            result = 1.0/temp;
            return result;
        }
    }


    public static void main(String[] args){
        System.out.println(Power(11.11,3));
    }
}
