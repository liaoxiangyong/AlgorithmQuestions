package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/25.
 */
public class IsBalanced_Solution_39 {

    //输入一棵二叉树，判断该二叉树是否是平衡二叉树。 左右子树的高度差不超过1
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int result[] = new int[1];
        int leftHeight = 0;     //记录左子树高度
        if(root.left!=null){
            findTreeHeight(result,0,root.left);
            leftHeight = result[0];
        }
        result[0] = 0;
        int rightHeight = 0;
        if(root.right!=null) {
            findTreeHeight(result, 0, root.right);
            rightHeight = result[0];
        }

        if(Math.abs(leftHeight-rightHeight)>1) return false;        //绝对值差大于1，返回false

        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    public void findTreeHeight(int result[],int height,TreeNode node){
        if(node.left==null&&node.right==null){
            height += 1;
            if(height>result[0]){
                result[0] = height;
                return;
            }
        }
        if(node.left != null)
            findTreeHeight(result,height+1, node.left);
        if(node.right != null)
            findTreeHeight(result,height+1,node.right);
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
//        root1.right = root3;
        root2.left = root4;
//        root2.right = root5;
//        root3.left = root6;
//        root3.right = root7;

        IsBalanced_Solution_39 a = new IsBalanced_Solution_39();
        System.out.println(a.IsBalanced_Solution(root1));
    }
}
