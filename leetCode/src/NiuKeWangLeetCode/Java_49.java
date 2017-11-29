package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/29.
 */
public class Java_49 {

    public boolean isSameTree(TreeNode p, TreeNode q) {         //判断两棵树是否是一样的
        if(p == null && q ==null) return true;
        if(p==null || q == null) return false;
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
