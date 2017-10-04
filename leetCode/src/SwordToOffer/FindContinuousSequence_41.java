package SwordToOffer;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/9/26.
 */
public class FindContinuousSequence_41 {

    //小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!  输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {//序列肯定在0到sum/2之间
        //方法一：遍历数组两次，时间复杂度为o(sum^2),估计会超时，略
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //方法二：直接用数组i模拟了一个窗口，窗口一直右移；本质还是双指针，用list模拟了。。。
        if(sum==1 || sum==2) return result;
//        List<Integer> list = new LinkedList<Integer>();
//        int listSum = 0;    //用来记录当前list中的sum
//        for(int i=1;i<=sum/2+2;){
//            if(listSum<sum){        //list当前和小于sum
//                if(listSum+i<=sum){ //加入当前值还小于sum则将其加入list中
//                    list.add(i);
//                    listSum += i;
//                    i++;
//                }else if(listSum+i>sum){      //若大于则将list第一位去掉
//                    listSum -= list.get(0);
//                    list.remove(0);
//
//                }
//            }else if(listSum == sum){
//                result.add(new ArrayList<>(list));
//                listSum -= list.get(0);
//                list.remove(0);
//            }else{
//                listSum -= list.get(0);
//                list.remove(0);
//            }
//        }



        //方法三：直接双指针;若小于加上当前最后值，并将区间右指针右移，若大于则将指针左移
        int start = 1;
        int end = 1;

        int length = sum/2+1;

        int listSum = 0;
        while(start<=end && end <= length){
            int temp = listSum + end;

            while(temp>sum && start<length){
                listSum -= start;
                temp -= start;
                start++;
            }

            if(temp == sum){   //相等,也把当前数加入其中
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i=start;i<=end;i++){
                    arrayList.add(i);
                }
                result.add(new ArrayList<>(arrayList));
            }
            listSum += end;
            end++;
        }

        return result;
    }

    public static void main(String[] args){
        FindContinuousSequence_41 a = new FindContinuousSequence_41();
        ArrayList<ArrayList<Integer>> result = a.findContinuousSequence(1000);
        System.out.println();
    }
}
