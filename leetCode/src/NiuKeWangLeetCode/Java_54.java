package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/3.
 */
public class Java_54 {

    public int numTrees(int n) {  //给定一个整数n，由1-n的数可以构造多少棵不同的二叉搜索树
        if(n==0 || n==1) return 1;
        int[] result = new int[n+1];
        result[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                result[i] += result[j] * result[i-j-1];
            }
        }
        return result[n];
    }
}


