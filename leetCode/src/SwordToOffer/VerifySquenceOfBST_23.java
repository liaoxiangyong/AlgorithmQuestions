package SwordToOffer;

import java.util.Arrays;

/**
 * Created by LXY on 2017/9/20.
 */
public class VerifySquenceOfBST_23 {
    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        return isRight(sequence);
}

    public boolean isRight(int [] sequence){
        if(sequence.length==0) return true;
        int root = sequence[sequence.length-1];     //最后一个点为根节点，,数组可以被改根节点分为两部分，前面都小于，后面都大于；然后大于根节点的为右子树点，小于根节点的为左
        int index = 0;
        for(int i=0;i<sequence.length-1;i++){
            index++;
            if(sequence[i]>root){
                index = i;
                break;
            }
        }
        //判断后面的点是否是都大于root的，若不是则返回false
        for(int i=index+1;i<sequence.length-1;i++){
            if(sequence[i]<root) return false;
        }
        int[] leftSequence = Arrays.copyOfRange(sequence,0,index);      //左子树点
        int[] rightSequence = Arrays.copyOfRange(sequence,index,sequence.length-1);     //右边的点

        return isRight(leftSequence)&&isRight(rightSequence);
    }

    public static void main(String[] args){
        int[] a = {7,9,10,6,5};
//        System.out.println(VerifySquenceOfBST(a));
    }
}
