package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by LXY on 2017/10/7.
 */
public class Java_7 {

    //Given a binary tree, return the preorder traversal of its nodes' values.
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null) return arrayList;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            arrayList.add(node.val);
            if(node.right!=null) {
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        Java_7 a = new Java_7();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        node1.left  = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        a.preorderTraversal(node1);
    }
}
