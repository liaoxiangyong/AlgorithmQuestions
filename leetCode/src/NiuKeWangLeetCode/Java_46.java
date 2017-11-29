package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by LXY on 2017/11/29.
 */
public class Java_46 {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {      //z字形打印二叉树的每一层
        ArrayList<ArrayList<Integer>> resutl = new ArrayList<>();
        if(root == null)
            return resutl;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean isLeftFirst = true;
        while(!stack.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            Stack<TreeNode> newStack = new Stack<>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                arrayList.add(node.val);
                if(isLeftFirst){
                    if(node.left!=null)
                        newStack.add(node.left);
                    if(node.right!=null)
                        newStack.add(node.right);
                }else{
                    if(node.right!=null)
                        newStack.add(node.right);
                    if(node.left!=null)
                        newStack.add(node.left);
                }
            }
            stack = (Stack<TreeNode>) newStack.clone ();
            isLeftFirst = !isLeftFirst;
            resutl.add(new ArrayList<>(arrayList));
        }
        return resutl;
    }

    public static void main(String[] args) {
        Java_46 a = new Java_46();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);

        node1.left  = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        a.zigzagLevelOrder(node1);
    }
}
