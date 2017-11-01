package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LXY on 2017/11/1.
 */
public class Java_27 {      //求树的最大路径，从任一点开始，但是以父子关系连接
    public int maxPathSum(TreeNode root) {      //最大路径出现在叶子节点之间
        if(root == null) return 0;
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;

        findMaxSum(root,result);
        return result[0];
    }

    private int findMaxSum(TreeNode node,int[] result){
        if(node == null)
            return 0;

        int left = findMaxSum(node.left,result);
        int right = findMaxSum(node.right,result);

        int ans = Math.max(node.val,Math.max(left+node.val,right+node.val));        //记录从当前点经过能得到的最大值

        result[0] = Math.max(result[0],Math.max(ans,left+right+node.val));      //先比较从当前点向能得到的最大值和以该点左右子树能得到的最大值，然后和原来的最大值比较

        return ans;
    }



    public static void main(String[] args) {
        Java_27 a = new Java_27();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        a.maxPathSum(node1);
    }
}
