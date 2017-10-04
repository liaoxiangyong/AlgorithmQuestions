package SwordToOffer;
import SwordToOffer.PrintBinaryTree_4.TreeNode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/9/20.
 */
public class FindPath_24 {

    //输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {      //深度遍历即可
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if(root==null)
            return resultList;
        ArrayList<Integer> path = new ArrayList<Integer>();
        findThePath(resultList,path,root,target,0);
        return resultList;
    }

    public void findThePath(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> path, TreeNode node, int target, int sum){
        if(node.left==null&&node.right==null) {       //叶子节点
            if(node.val+sum==target){
                path.add(node.val);
                resultList.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(node.val);
        if(node.left!=null)findThePath(resultList,path,node.left,target,sum+node.val);
        if(node.right!=null)findThePath(resultList,path,node.right,target,sum+node.val);
        path.remove(path.size()-1);
    }

    public static void main(String[] args){
        FindPath_24 findPath_24 = new FindPath_24();
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(10);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);
        TreeNode root7 = new TreeNode(11);
        TreeNode root8 = new TreeNode(19);
        TreeNode root9 = new TreeNode(20);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right=root9;
        root6.right = root7;
        root4.left=root8;
        ArrayList<ArrayList<Integer>> resultList=findPath_24.FindPath(root1,38);
        System.out.println();
    }
}
