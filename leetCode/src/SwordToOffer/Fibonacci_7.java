package SwordToOffer;

/**
 * Created by LXY on 2017/9/18.
 */
public class Fibonacci_7 {
    /**
     * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     n<=39
     */
    public static int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args){
        System.out.println(Fibonacci(9));
    }
}
