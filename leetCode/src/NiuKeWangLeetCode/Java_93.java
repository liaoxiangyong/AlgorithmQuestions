package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2018/1/16.
 */
 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Java_93 {

    //给出一个按升序排序的非重叠区间序列，插入一个新区间，合并有重叠的区间
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {//分别找到新区间start和end所在位置（对不在区间单独判断），依次插入判断即可
        List<Interval> res = new ArrayList<>();
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start){
            res.add(intervals.get(i++));
        }
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end){     //有交叉区间
            newInterval = new Interval(
                    Math.min(intervals.get(i).start,newInterval.start),
                    Math.max(intervals.get(i).end,newInterval.end)
            );
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size())
            res.add(intervals.get(i++));
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(0,5);
        intervals.add(i1);
        Interval i2 = new Interval(9,12);
        intervals.add(i2);
        Interval i3 = new Interval(6,7);
//        intervals.add(i3);
        Interval i4 = new Interval(9,12);
//        intervals.add(i4);
        Java_93 a = new Java_93();
        a.insert(intervals,new Interval(7,16));
    }
}
