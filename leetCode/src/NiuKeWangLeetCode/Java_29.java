package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/3.
 */
public class Java_29 {
//    public static int maxProfit(int[] prices) {
//        //动态规划，找到将数据划分成两部分，分别求前面部分的最大利润和后面部分的最大利润，将两部分加在一起就是一个待选的最大收益，有n种可能，最后比较
//        if(prices ==null || prices.length==0 || prices.length ==1) return 0;
//        int[] leftProfit = new int[prices.length];
//        int minPrice = prices[0];
//        int maxProfit = 0;
//        for(int i=1;i<prices.length;i++){       //从前向后找，找到到i点的能得到的最大利润，最大利润为当前价格减去前面的最小价格和前一个最大利润之间的较大值
//            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
//            minPrice = Math.min(minPrice,prices[i]);
//            leftProfit[i] = maxProfit;
//        }
//
//        int[] rightProfit = new int[prices.length];
//        int maxPrice  = prices[prices.length-1];
//        maxProfit = 0;
//        for(int i=prices.length-2;i>=0;i--){        //从后向前找，找到到i点的能得到的最大利润，最大利润为当前最大价格减去当前价格和前后一个最大利润之间的较大值
//            maxProfit = Math.max(maxProfit,maxPrice-prices[i]);
//            maxPrice = Math.max(maxPrice,prices[i]);
//            rightProfit[i] = maxProfit;
//        }
//
//        maxProfit = 0;
//        for(int i=0;i<prices.length;i++){
//            maxProfit = Math.max(maxProfit,leftProfit[i]+rightProfit[i]);
//        }
//
//        return maxProfit;
//    }

    public static int maxProfit(int[] prices) {  //方法二
        if (prices == null || prices.length < 2)
            return 0;
        // 四个变量分别表示经过当前操作以后的profit
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, curPrice + firstBuy);
            secondBuy = Math.max(secondBuy, firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }
    public static void main(String[] args) {
        int [] b = {6,1,3,2,4,7};
        System.out.println(Java_29.maxProfit(b));
    }
}
