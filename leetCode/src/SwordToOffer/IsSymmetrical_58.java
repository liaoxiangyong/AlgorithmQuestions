package SwordToOffer;

import SwordToOffer.PrintBinaryTree_4.TreeNode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/9/30.
 */
public class IsSymmetrical_58 {

    //请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    boolean isSymmetrical(TreeNode pRoot){

        //方法一：将该树的每一个左右节点互换，然后看与之前的树是否一样

        //方法二：使用左中右，一个使用右中左遍历，得出的结果要一致
//        ArrayList<TreeNode> listLeftFirst = new ArrayList<>();
//        ArrayList<TreeNode> listRightsFirst = new ArrayList<>();
//        TreeNode node = pRoot;
//        leftRight(pRoot,listLeftFirst);
//        rightLeft(node,listRightsFirst);
//
//        for(int i=0;i<listLeftFirst.size();i++){
//            TreeNode node1 = listLeftFirst.get(i);
//            TreeNode node2 = listRightsFirst.get(i);
//            if(node1.val==node2.val){       //对于遍历中的每一个点判断值是否相等，结构是否相反
//                if(node1.left==null&&node2.right!=null)
//                    return false;
//                if(node1.right==null&&node2.left!=null)
//                    return false;
//                if(node1.left==null){
//                    if(node1.right==null){
//                    }else{
//                        if(node1.right.val != node2.left.val)
//                            return false;
//                    }
//                }else {
//                    if(node1.left.val != node2.right.val)
//                        return false;
//                    if(node1.right==null){
//                    }else{
//                        if(node1.right.val != node2.left.val)
//                            return false;
//                    }
//                }
//            }else{
//                return false;
//            }
//        }
//        return true;




        //方法三：递归。
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }


    private boolean comRoot(TreeNode left, TreeNode right) {
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }

    private void leftRight(TreeNode node, ArrayList<TreeNode> listLeftFirst){
        if(node==null) return;
        leftRight(node.left,listLeftFirst);
        listLeftFirst.add(node);
        leftRight(node.right,listLeftFirst);
    }

    private void rightLeft(TreeNode node, ArrayList<TreeNode> listRightsFirst){
        if(node==null) return;
        rightLeft(node.right,listRightsFirst);
        listRightsFirst.add(node);
        rightLeft(node.left,listRightsFirst);
    }


    public static void main(String[] args) {
        IsSymmetrical_58 a = new IsSymmetrical_58();

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node7.right = node9;

        System.out.println(a.isSymmetrical(node1));
    }
}
