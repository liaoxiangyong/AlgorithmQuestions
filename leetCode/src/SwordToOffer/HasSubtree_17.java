package SwordToOffer;
import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/19.
 */
public class HasSubtree_17 {

    //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null||root1==null) return false;
        return ergodicBinaryTree(root1,root2);
    }

    public static boolean  ergodicBinaryTree(TreeNode node,TreeNode root2) {     //遍历二叉树
        if(node==null&&root2==null) return true;
        if(node==null&&root2!=null) return false;
        if(node!=null&&root2==null) return true;
        if(node.val == root2.val){
            boolean result= compareBinaryTree(node.left,root2.left)&&ergodicBinaryTree(node.right,root2.right);
            if(result==true) return result;
        }
        return ergodicBinaryTree(node.left, root2)||ergodicBinaryTree(node.right, root2);
    }

    public static boolean  compareBinaryTree(TreeNode root1,TreeNode root2) {     //遍历二叉树
        if(root1==null&&root2==null) return true;
        if(root1==null&&root2!=null) return false;
        if(root1!=null&&root2==null) return true;
        if(root1.val == root2.val){
            return compareBinaryTree(root1.left,root2.left)&&ergodicBinaryTree(root1.right,root2.right);
        }
        return false;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(9);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root5.left = root6;
        root5.right = root7;

        TreeNode roota = new TreeNode(8);
        TreeNode rootb = new TreeNode(9);
        TreeNode rootc = new TreeNode(2);
        TreeNode rootd = new TreeNode(9);
        roota.left = rootb;
        roota.right = rootc;
        rootc.right=rootd;


        System.out.println(HasSubtree(root1,roota));
    }
}
