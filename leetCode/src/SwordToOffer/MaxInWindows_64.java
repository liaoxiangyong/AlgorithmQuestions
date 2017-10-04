package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by LXY on 2017/10/1.
 */
public class MaxInWindows_64 {

    //给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(num==null || num.length<size || size==0) return arrayList;

        LinkedList<Integer> indexDeque = new LinkedList<>();        //用于保存滑动窗口中的数字

        //  滑动窗口内部，用于判断窗口中的最大值
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);                  //将数字下标存入滑动窗口中
        }


        //    滑动整个窗口
        for(int i=size-1;i<num.length;i++){
            while(!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);                  //将数字下标存入滑动窗口中

            if(i - indexDeque.getFirst() + 1 > size){
                indexDeque.removeFirst();
            }
            arrayList.add(num[indexDeque.getFirst()]);        //每次添加的是num[indexDeque.getFirst()],而不是indexDeque.getFirst().
        }
        return arrayList;
    }

    public static void main(String[] args) {
        MaxInWindows_64 a = new MaxInWindows_64();
        int[] b = {2,3,4,2,6,2,5,1};
        a.maxInWindows(b,3);
    }
}
