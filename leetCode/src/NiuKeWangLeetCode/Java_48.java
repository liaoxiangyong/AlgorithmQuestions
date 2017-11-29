package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/29.
 */
public class Java_48 {
    public boolean isSymmetric(TreeNode root) {     //判断一棵二叉树是否是对称的
        if(root == null) return true;
        return isSys(root.left,root.right);
    }

    private boolean isSys(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 ==null) return true;
        if(node1== null || node2==null) return false;
        if(node1.val == node2.val) {
            return isSys(node1.left,node2.right) && isSys(node1.right,node2.left);
        }
        return false;
    }
}
