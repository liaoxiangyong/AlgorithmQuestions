package SwordToOffer;

/**
 * Created by LXY on 2017/9/28.
 */
public class Multiply_51 {

    //给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    public int[] multiply(int[] A) {

        int[] B = new int[A.length];
        //方法一：直接暴力，估计会超时，略
        //方法二：      化框图,将数组分成两半，一次循环记录两边的值，即B[i] = C[I]*D[I]
        int[] C = new int[A.length];
        int[] D = new int[A.length];

        D[0] = 1; // 计算D
        for(int i=1;i<A.length;i++){
            D[i] = D[i-1] * A[i-1];
        }

        C[A.length-1] = 1; // 计算C
        for(int i = A.length-1;i>0;i--){
            C[i-1] = C[i] * A[i];
        }


        for(int i =0;i<A.length;i++){
            B[i] = C[i] * D[i];
        }
        return B;
    }

    public static void main(String[] args){
        Multiply_51 a = new Multiply_51();
        int[] b = {1,2,3,4,5};
        System.out.println(a.multiply(b));
    }
}
