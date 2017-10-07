package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by LXY on 2017/10/5.
 */
public class Java_6 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null) return arrayList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.peek();
            while(treeNode.left!=null){
                stack.push(treeNode.left);
                treeNode.left = null;
                treeNode = stack.peek();
            }

            TreeNode node = stack.peek();
            if(node.right!=null){
                stack.push(node.right);
                node.right = null;
            }else{
                TreeNode temp = stack.pop();
                arrayList.add(temp.val);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Java_6 a = new Java_6();
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
        a.postorderTraversal(node1);
    }
}
