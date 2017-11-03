package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/3.
 */
public class Java_29 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int [] b = {3,8,4,5,10,6,7,1,2,9};
        System.out.println(Java_29.maxProfit(b));
    }
}
