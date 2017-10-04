package SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by LXY on 2017/9/24.
 */
public class PrintMinNumber_32 {
    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    public String PrintMinNumber(int [] numbers) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String sum1 = o1.toString()+o2.toString();
                String sum2 = o2.toString()+o1.toString();

                return sum1.compareTo(sum2)>0?1:-1;
            }
        };
        String[] arr = new String[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            arr[i] = numbers[i]+"";
        }
        Arrays.sort(arr,comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args){
        PrintMinNumber_32 a = new PrintMinNumber_32();
        int[] b = {3,32,321,444,1,2,21};
        System.out.println(a.PrintMinNumber(b));
    }
}
