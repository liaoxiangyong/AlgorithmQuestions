package SwordToOffer;

/**
 * Created by LXY on 2017/9/25.
 */
public class InversePairs_35 {
    //数组中的逆序对:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
    public int InversePairs(int [] array) {

        //方法一：遍历，复杂度为0(n^2)，估计会超时
//        int count = 0;
//        for(int i=0;i<array.length;i++){
//            for(int j=i+1;j<array.length;j++){
//                if(array[i]>array[j])
//                    count++;
//            }
//        }
//        return count%1000000007;

        //方法二：使用归并排序
        if(array == null) return 0;
        int length = array.length;
        int[] temp = new int[length];
        for(int i=0;i<array.length;i++){
            temp[i] = array[i];
        }
        long result = findCount(array,temp,0,length-1);
        return (int)(result%1000000007);
    }


    private long findCount(int[] array,int[] temp,int start,int end){
        if(start == end){
            temp[start] = array[start];
            return 0;
        }
        int mid = (start + end)/2;
        long left = findCount(array, temp, start, mid);
        long right = findCount(array, temp, mid + 1, end);

        int i = mid;
        int j = end;

        long count = 0;  //记录两个数组间的逆序对
        int pos = end;    //temp数组的下标
        while(i>=start&&j>=mid+1){
            if(array[i]>array[j]){
                temp[pos--] = array[i--];
                count += j - mid;
            }else{
                temp[pos--] = array[j--];
            }
        }
        while(i>=start){
            temp[pos--] = array[i--];
        }
        while (j>=mid+1){
            temp[pos--] = array[j--];
        }
        for(int k=start;k<=end;k++){
            array[k] = temp[k];
        }
        return left + right + count;
    }


    public static void main(String[] args){
        InversePairs_35 a  = new InversePairs_35();
        int[] b = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(a.InversePairs(b));
    }
}
