package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by LXY on 2017/9/30.
 */
public class Print_59 {

    //请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);

        boolean leftOrRight = true;        //true代表左到右，false代表右到左
        while(!stack.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<TreeNode> tempStack = new LinkedList<>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(leftOrRight){
                    if(node.left!=null){
                        tempStack.add(node.left);
                    }
                    if(node.right!=null){
                        tempStack.add(node.right);
                    }
                }else{
                   if(node.right!=null){
                        tempStack.add(node.right);
                    }
                    if(node.left!=null){
                        tempStack.add(node.left);
                    }
                }
                arrayList.add(node.val);
            }
            leftOrRight = !leftOrRight;
            res.add(new ArrayList<>(arrayList));
            for(int i = 0;i<tempStack.size();i++)
                stack.add(tempStack.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Print_59 a = new Print_59();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(12);
        TreeNode node8 = new TreeNode(6);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(14);
        TreeNode node11 = new TreeNode(13);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        node6.right = node10;
        node7.right = node11;
        node9.left = node12;
        node9.right = node13;
        a.Print(node1);
    }
}
