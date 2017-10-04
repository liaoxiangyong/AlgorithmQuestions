package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LXY on 2017/9/20.
 */
public class PrintFromTopToBottom_22 {
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root==null) return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int i=0;
            while(i<size){
                TreeNode treeNode = queue.poll();
                arrayList.add(treeNode.val);
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                if(treeNode.right!=null)
                    queue.add(treeNode.right);
                i++;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
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

        ArrayList<Integer> arrayList = PrintFromTopToBottom(root1);
        System.out.println();
    }
}
