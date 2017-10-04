package SwordToOffer;

import java.util.Arrays;

/**
 * Created by LXY on 2017/9/17.
 */
public class PrintBinaryTree_4 {      //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return constructBinaryTree(pre,in);
    }

    public TreeNode constructBinaryTree(int [] pre,int [] in) {
       TreeNode node;
        if(pre.length==0){
            node = null;
            return node;
        }
        int rootValue = pre[0];     //先序遍历第一个点是根节点
        node = new TreeNode(rootValue);
        int index =0; //记录根节点在中序遍历的位置
        for(int i=0;i<in.length;i++){
            if(rootValue == in[i]){
                index = i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(pre,1,index+1);        //左子树前序遍历
        int[] leftIn = Arrays.copyOfRange(in,0,index);    //左子树中序遍历

        int[] rightPre = Arrays.copyOfRange(pre,index+1,pre.length);       //右子树前遍历
        int[] rightIn = Arrays.copyOfRange(in,index+1,in.length);      //右子树中序遍历

        node.left=constructBinaryTree(leftPre,leftIn);
        node.right=constructBinaryTree(rightPre,rightIn);

        return node;
    }

    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        //TreeNode root = new TreeNode(1);
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        PrintBinaryTree_4 printBinaryTree_4 = new PrintBinaryTree_4();
        printBinaryTree_4.reConstructBinaryTree(pre,in);
    }
}
