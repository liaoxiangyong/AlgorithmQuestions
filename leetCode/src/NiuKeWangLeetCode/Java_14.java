package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/13.
 */
public class Java_14 {

    //数组中除了一个数，其他数都出现了三次，求出这个数
    public int singleNumber(int[] A) {

        //二进制数相加，然后对3取余，出现三次的位置就变成0了，剩下的自然就是只出现一次的数了
        if(A == null || A.length == 0 ) return 0;
        int[] arr = new int[32];


        for(int i=0;i<A.length;i++){
            for(int j=0;j<32;j++){
                arr[j] += (A[i]&1);
                A[i] =A[i]>>1;
            }
        }

        int sum = 0;
        for(int i=0;i<32;i++){      //对应位对三取余
            sum += (arr[i]%3) * (1<<i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Java_14 a = new Java_14();
        int[] A = {2,2,3,4,3,3,2,5,5,5,4,4,8};
        System.out.println(a.singleNumber(A));
    }
}
