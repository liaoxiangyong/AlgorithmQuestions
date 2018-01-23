package NiuKeWangLeetCode;


/**
 * Created by LXY on 2018/1/23.
 */
public class Java_101 {
    public double myPow(double x, int n) {
        if(n < 0)
            return 1/pow(x,-n);
        else
            return pow(x,n);
    }

    private double pow(double x, int n) {        //计算x的n次方
        if(n==0) return 1.0;
        double tmp=pow(x,n/2);
        if(n%2==0)
            return tmp*tmp;
        else
            return tmp*tmp*x;
    }
}
