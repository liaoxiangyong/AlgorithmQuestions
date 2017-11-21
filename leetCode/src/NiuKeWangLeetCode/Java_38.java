package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_38 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return sum(root,0,sum);
    }

    public boolean sum(TreeNode node,int now,int sum){
        if(node == null) return false;
        if(node.left == null && node.right==null){      //叶子节点判断
            if(now + node.val == sum){
                return true;
            }
        }
        return sum(node.left,now+node.val,sum) || sum(node.right,now+node.val,sum);
    }


    public static void main(String[] args) {
        Java_38 a = new Java_38();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(19);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6= new TreeNode(6);
        node1.left  = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(a.hasPathSum(node1,29));
    }
}
