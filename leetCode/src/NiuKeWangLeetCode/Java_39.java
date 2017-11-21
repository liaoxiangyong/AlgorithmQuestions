package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_39 {

    public boolean isBalanced(TreeNode root) {      //判断一颗二叉树是不是二叉平衡树
        if(root == null)
            return true;
        int left =  countMaxLength(root.left);//记录左子树的高度
        int right =  countMaxLength(root.right); //记录右子树的高度
        if(Math.abs(left-right)>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int countMaxLength(TreeNode node){  //计算当前点最大高度
        if(node==null) return 0;
        return Math.max(countMaxLength(node.left),countMaxLength(node.right))+1;
    }
}
