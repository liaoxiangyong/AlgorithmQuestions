package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/13.
 */
public class Java_15 {

    //数组中除了一个数之外其他数都出现了两次，求这个数
    public int singleNumber(int[] A) {

        int res = 0;
        for(int i=0;i<A.length;i++){
            res ^= A[i];
        }

        return res;
    }


    public static void main(String[] args) {
        Java_15 a = new Java_15();

        int A[] = {2,3,4,6,7,8,8,7,6,2,3,4,9};
        System.out.println(a.singleNumber(A));
    }
}
