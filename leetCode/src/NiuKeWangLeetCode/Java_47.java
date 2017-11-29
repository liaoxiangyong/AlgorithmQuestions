package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LXY on 2017/11/29.
 */
public class Java_47 {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {            //按层打印二叉树
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int i=0, size  = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while(i<size&&!queue.isEmpty()){
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right !=null)
                    queue.add(node.right);
                i++;
            }
            result.add(new ArrayList<>(arrayList));
        }
        return result;
    }

    public static void main(String[] args) {
        Java_47 a = new Java_47();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);

        node1.left  = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        a.levelOrder(node1);
    }
}
