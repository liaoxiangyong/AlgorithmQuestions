package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/21.
 */
public class Convert_26 {

    TreeNode pre = null;
    TreeNode head = null;
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree==null)
            return null;
        ConvertTree(pRootOfTree);
        return head;
    }

    public void ConvertTree(TreeNode pRootOfTree){
        if(pRootOfTree == null) return;
        ConvertTree(pRootOfTree.left);
        if(pre == null){        //记录起始节点
            pre = pRootOfTree;
            head = pRootOfTree;
        }else{
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        ConvertTree(pRootOfTree.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(10);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);
        TreeNode root7 = new TreeNode(11);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root6.right = root7;
        Convert_26 convert_26 = new Convert_26();
        TreeNode node =  convert_26.Convert(root1);

    }
}
