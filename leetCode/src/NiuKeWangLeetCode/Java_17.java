package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/17.
 */
public class Java_17 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //贪心算法，首先找到剩余最多油的点，然后从该点走，如果从该点走都不能达到，说明到不了
        int length  = gas.length;

        int sum = 0;
        int start = 0;
        int total = 0;

        for(int i=0;i<length;i++){
            total += gas[i] - cost[i];
            if(sum<0){   //发现油箱空了，从下一个站点尝试
                start=i;
                sum=gas[i]-cost[i];
            }else{
                sum += gas[i] - cost[i];
            }
        }

        return total>=0?start:0;
    }

    public static void main(String[] args) {
        Java_17 a = new Java_17();
        int[] gas = {4,5,7,2,1,6,7};
        int[] cost = {6,3,1,2,1,2,7};
        a.canCompleteCircuit(gas,cost);
    }
}
