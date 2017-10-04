package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/25.
 */
public class TreeDepth_38 {

    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int result[] = new int[1];      //用来记录当前树的最大长度
        findDepth(result,0,root);
        return result[0];
    }


    public void findDepth(int[] result, int nowDepth, TreeNode node){
        if(node.left==null && node.right==null){        //根节点
            nowDepth += 1;
            if(nowDepth > result[0])
                result[0] = nowDepth;
            return;
        }
        if(node.left!=null){
            findDepth(result,nowDepth+1,node.left);
        }
        if(node.right!=null){
            findDepth(result,nowDepth+1,node.right);
        }
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(10);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);
        TreeNode root7 = new TreeNode(11);
//        root1.left = root2;
//        root1.right = root3;
//        root2.left = root4;
//        root2.right = root5;
//        root3.left = root6;
//        root6.right = root7;

        TreeDepth_38 a = new TreeDepth_38();
        System.out.println(a.TreeDepth(root1));
    }
}
