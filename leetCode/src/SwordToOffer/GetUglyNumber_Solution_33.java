package SwordToOffer;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by LXY on 2017/9/24.
 */
public class GetUglyNumber_Solution_33 {

    //把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    public int GetUglyNumber_Solution(int index) {

        if(index<=0) return 0;
        SortedSet<Long> sortedSet = new TreeSet<>();        //使用long是防止int*2,3,5之后溢出
        sortedSet.add((long)1);
        long res = sortedSet.first();
        for(int i=0;i<index-1;i++){
            res = sortedSet.first();
            sortedSet.add(res*2);
            sortedSet.add(res*3);
            sortedSet.add(res*5);
            sortedSet.remove(res);
        }
        return (int)(long)sortedSet.first();
    }

    public static void main(String[] args){
        GetUglyNumber_Solution_33 a = new GetUglyNumber_Solution_33();
        System.out.println(a.GetUglyNumber_Solution(8));
    }
}
