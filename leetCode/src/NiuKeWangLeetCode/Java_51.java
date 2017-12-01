package NiuKeWangLeetCode;

import java.util.Stack;

/**
 * Created by LXY on 2017/12/1.
 */
public class Java_51 {

    public boolean isValidBST(TreeNode root) {      //判断一棵二叉树是否是二叉搜索树
        TreeNode preNode = null;
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()){
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
             TreeNode node= stack.pop();
            if(preNode !=null && preNode.val >= node.val)
                return false;
            preNode = node;
            root = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Java_51 a = new Java_51();
        a.isValidBST(node1);
    }
}
