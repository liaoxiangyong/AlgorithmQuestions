package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/29.
 */
public class Java_50 {
    public void recoverTree1(TreeNode root) {                //一棵二叉搜索树的 两个点顺序错了，恢复它
        //方法一：找到交换的两个点，这里有两种情况，（1）一种是相邻两个点交换，这样只出现一次逆序（2）一种是不相邻两个点交换，出现两个逆序，交换的两个点分别为第一次逆序的第一个点和第二次逆序的第二个点，找到这两个点，然后交换

    }




    TreeNode firstNode = null;
    TreeNode secondNode = null;

    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {                //一棵二叉搜索树的 两个点顺序错了，恢复它
        //找出顺序交换的两个点，交换点有两种情况：（1）一种是相邻两个点交换，这样只出现一次逆序（2）一种是不相邻两个点交换，出现两个逆序，交换的两个点分别为第一次逆序的第一个点和第二次逆序的第二个点，找到这两个点，然后交换
        traverse(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void traverse(TreeNode node){
        if(node == null)
            return;
        traverse(node.left);

        if(firstNode == null && prevElement.val >= node.val){       //逆序
            firstNode = prevElement;
        }
        if(firstNode!=null && prevElement.val>=node.val)
            secondNode = node;
        prevElement = node;

        traverse(node.right);
    }
}
