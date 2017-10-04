package SwordToOffer;

/**
 * Created by LXY on 2017/9/28.
 */
public class Add_48 {

    //写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    public int Add(int num1,int num2) {

        //方法一：使用BigInteger
//        BigInteger integer1  = new BigInteger(String.valueOf(num1));
//        BigInteger integer2  = new BigInteger(String.valueOf(num2));
//        return integer1.add(integer2).intValue();


        //方法二：使用二进制相加，（1）相加各位的值，不算进位 （2）计算进位，然后和（1）的值相加 （3）重复（1）、（2）
        int sum;      //不含进位的和
        int add;   //含进位的和

        while(num2 != 0){
            sum = num1^ num2;
            add = (num1&num2) <<1;

            num1 = sum;
            num2 = add;
        }
        return num1;
    }

    public static void main(String[] args){
        Add_48 a = new Add_48();
        System.out.println(a.Add(6,9));
    }
}
