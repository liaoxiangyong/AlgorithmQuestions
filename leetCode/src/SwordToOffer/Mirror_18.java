package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/19.
 */
public class Mirror_18 {

    //交换二叉树的左右子树
    public static void Mirror(TreeNode root) {
        exchangeChildren(root);
    }

    public static void exchangeChildren(TreeNode root){
        if(root==null) return;
        if(root!=null){
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
        }
        exchangeChildren(root.left);
        exchangeChildren(root.right);
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
        root3.right = root7;

        Mirror(root1);
    }
}
