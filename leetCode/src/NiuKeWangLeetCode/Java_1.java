package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/2.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class Java_1 {

    public int run(TreeNode root) {
        if(root == null) return 0;
        int[]  min = new int[1];
        min[0] =  Integer.MAX_VALUE;
        getMinDepth(1,root,min);

        return min[0];
    }


    private void getMinDepth(int depth,TreeNode node,int[] min){
        if(node.left == null && node.right==null){
            if(depth<min[0])
                min[0] = depth;
            return;
        }

        if(node.left!=null) getMinDepth(depth+1,node.left,min);
        if(node.right!=null) getMinDepth(depth+1,node.right,min);
    }

    public static void main(String[] args) {
        Java_1 a = new Java_1();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);

        node1.left  = node2;
        node1.right = node3;
        node3.left = node4;
        System.out.println(a.run(node1));
    }
}

