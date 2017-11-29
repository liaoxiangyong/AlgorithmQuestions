package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/28.
 */
public class Java_45 {

    public int maxDepth(TreeNode root) {  //求一棵二叉树的高度

        if(root == null) return 0;
        int[] max =new int[1] ;
        findMax(root,max,1);
        return max[0];
    }

    public void findMax(TreeNode node,int[] max,int depth){
        if(node.left == null && node.right==null){
            if(depth>max[0])
                max[0] = depth;
            return;
        }
        if(node.left!=null){
            findMax(node.left,max,depth +1);
        }
        if(node.right!=null){
            findMax(node.right,max,depth+1);
        }
    }

}
