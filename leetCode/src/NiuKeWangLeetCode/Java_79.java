package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/25.
 */
public class Java_79 {
    public int climbStairs(int n) {         //一个n步的梯子，每次能往上爬一步或者两步，问到达第n步有多少种方法
        if(n<=2) return n;
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for(int i=2;i<n;i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n-1];
    }
}
