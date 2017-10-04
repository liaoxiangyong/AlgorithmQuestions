package SwordToOffer;
import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/10/1.
 */
public class KthNode_62 {

    //给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(k==0) return null;
        //方法一：中序遍历整个数
        int[] count = new int[1];
        TreeNode[] res = new TreeNode[1];
        TreeNode resNode = null;
        getKNode(count,pRoot,k,res);
        return res[0];
    }

    private void getKNode(int[] count, TreeNode node, int k, TreeNode[] res){
        if(node == null) return;
        getKNode(count,node.left,k,res);
        count[0]++;
        if(count[0]==k){
            res[0] = new TreeNode(node.val);
        }
        getKNode(count,node.right,k,res);
    }

    public static void main(String[] args) {
        KthNode_62 a = new KthNode_62();

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(a.KthNode(node1,10).val);
    }
}
