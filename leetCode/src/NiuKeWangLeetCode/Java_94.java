package NiuKeWangLeetCode;/**
 * Created by LXY on 2018/1/18.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java_94 {

    public List<Interval> merge(List<Interval> intervals) {         //合并区间，1、先把区间按照升序排序，然后遍历区间，看有无重叠区间
        List<Interval> list = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                else
                    return o1.end - o2.end;
            }
        });

        for(int i=0;i<intervals.size();i++){
            Interval now = intervals.get(i);
            if(i==0)
                list.add(now);
            else{   //判断有无重叠区间（即当前区间的start小于list中最后一个区间的end）
                Interval old = list.get(list.size()-1);
                if(now.start > old.end){      //重叠区间，直接加入
                    list.add(now);
                }else{      //有重叠，取now的end和list最后一个区间的end的较大值作为新区间的end
                    list.remove(list.size()-1);
                    int newEnd = Math.max(now.end,old.end);
                    Interval newInterval = new Interval(old.start,newEnd);
                    list.add(newInterval);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Java_94 a = new Java_94();
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1,3);
        intervals.add(i1);
        Interval i2 = new Interval(1,5);
        intervals.add(i2);
        Interval i3 = new Interval(8,10);
        intervals.add(i3);
        Interval i4 = new Interval(3,7);
        intervals.add(i4);
        a.merge(intervals);
    }
}
