package NiuKeWangLeetCode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_37 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        getResult(result,arrayList,root,sum);
        return result;
    }

    public void getResult(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arrayList,TreeNode node,int sum) {
        if(node == null) return;
        if(node.left == null && node.right == null){
            if(sum == node.val){
                arrayList.add(node.val);
                result.add(new ArrayList<>(arrayList));
                arrayList.remove(arrayList.size()-1);
            }
            return;
        }
        arrayList.add( node.val);
        getResult(result,arrayList,node.left,sum-node.val);
        getResult(result,arrayList,node.right,sum-node.val);
        arrayList.remove(arrayList.size()-1);
    }

    public static void main(String[] args) {
        Java_37 a = new Java_37();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(19);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6= new TreeNode(12);
        node1.left  = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(a.pathSum(node1,22));
    }
}
