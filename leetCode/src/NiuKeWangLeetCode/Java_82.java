package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/8.
 */
public class Java_82 {

    public int[] plusOne(int[] digits) {        //给一个用数组表示的数，求加一之后的结果，结果还是用数组表示。

        if(digits==null || digits.length==0) return digits;
        int[] res = new int[digits.length];
        digits[digits.length-1]++;
        int count = 0;
        int sum = 0;
        for(int i = digits.length-1;i>=0;i--){
            sum = count + digits[i];
            if(sum >= 10){
                res[i] = (sum) % 10;
                count = (sum) / 10;
            }else{
                res[i] = sum;
                count = 0;
            }
        }
        if(sum <10)
            return res;
        else{
            int[] a = new int[res.length+1];
            a[0] = 1;
            return a;
        }
    }

    public static void main(String[] args) {
        Java_82 a = new Java_82();
        int[] digits = {2,4,9,3,9};
        a.plusOne(digits);
    }
}
