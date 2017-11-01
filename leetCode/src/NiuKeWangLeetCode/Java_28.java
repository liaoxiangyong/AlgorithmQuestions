package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/1.
 */
public class Java_28 {

    public int maxProfit(int[] prices) {    //给出一个股票每天的股价，只能买一次，然后卖一次，求能够得到的最大利润
        if(prices.length==0 || prices == null || prices.length ==1) return 0;
        int[] sub = new int[prices.length-1];
        for(int i=1;i<prices.length;i++){
            sub[i-1] = prices[i] - prices[i-1];
        }

        int max = sub[0];
        int sum = sub[0];
        for(int i=1;i<sub.length;i++){
            if(sub[i]>=sub[i]+sum){
                sum = sub[i];
            }else{
                sum += sub[i];
            }
            max = Math.max(sum,max);
        }
        return max>0?max:0;
    }

    public static void main(String[] args) {
        Java_28 a = new Java_28();
        int[] b = {2,1,4};
        System.out.println(a.maxProfit(b));
    }
}
