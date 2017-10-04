package SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by LXY on 2017/10/1.
 */
public class GetMedian_63 {

    //如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    //方法一：用一个list来维持
//    List<Integer> list = new ArrayList<>();     //插入的时候就让他有序，这样插入的复杂度为O(n)
//    public void Insert(Integer num) {
//        int i=0;
//        for(;i<list.size();i++){
//            if(num<list.get(i))
//                break;
//        }
//        list.add(i,num);
//    }
//
//    public Double GetMedian() {
//        int size = list.size();
//        if(size%2==0){
//            double res = ((double)(list.get(size/2-1)+list.get(size/2)))/2;
//            return res;
//        }else{
//            return (double)list.get(size/2);
//        }
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();     //最小堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {     //最大堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }


    public static void main(String[] args) {
        double x ;
        GetMedian_63 a = new GetMedian_63();
        a.Insert(4);
        x = a.GetMedian();
        a.Insert(2);
        x = a.GetMedian();
        a.Insert(19);
        x = a.GetMedian();
        a.Insert(15);
        x = a.GetMedian();
        a.Insert(3);
        x = a.GetMedian();
    }
}
