package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_42 {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {   //从下往上，从左到右打印每一层的节点
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root ==null) return result;
        ArrayList<Integer> arrayList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
           Queue<TreeNode> next = new LinkedList<>();
           while(!queue.isEmpty()){
               TreeNode node = queue.poll();
               arrayList.add(node.val);
               if(node.left!=null)
                   next.add(node.left);
               if(node.right!=null)
                   next.add(node.right);
           }
           result.add(0,new ArrayList<>(arrayList));
           arrayList.clear();
           queue = new LinkedList<>(next);
           next.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        Java_42 a = new Java_42();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);

        node1.left  = node2;
        node1.right = node3;
        node3.left = node4;
        a.levelOrderBottom(node1);
    }
}
