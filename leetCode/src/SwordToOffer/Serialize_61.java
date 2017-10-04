package SwordToOffer;
import SwordToOffer.PrintBinaryTree_4.TreeNode;

/**
 * Created by LXY on 2017/9/30.
 */
public class Serialize_61 {
    //请实现两个函数，分别用来序列化和反序列化二叉树

    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        rootFirst(stringBuilder,root);
        return stringBuilder.toString();
    }

    private void rootFirst(StringBuilder stringBuilder,TreeNode node){
        if(node == null){
            stringBuilder.append("#!");
        }else {
            stringBuilder.append(node.val+"!");
            rootFirst(stringBuilder,node.left);
            rootFirst(stringBuilder,node.right);
        }
    }

    TreeNode Deserialize(String str) {
        if(str==null||str.length()==0) return null;

        String[] strings = str.split("!");
        int[] index = new int[1];       //用来保存坐标
        return constructedTree(index,strings);
    }

    private TreeNode constructedTree(int[] index , String[] strings){
        if(index[0]>strings.length-1) return null;
        if(strings[index[0]].equals("#")){
            index[0]++;
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(strings[index[0]]));
            index[0]++;
            node.left = constructedTree(index,strings);
            node.right = constructedTree(index,strings);
            return node;
        }
    }

    public static void main(String[] args) {
        Serialize_61 a = new Serialize_61();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(12);
        TreeNode node8 = new TreeNode(6);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(14);
        TreeNode node11 = new TreeNode(13);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        node6.right = node10;
        node7.right = node11;
        node9.left = node12;
        node9.right = node13;

        System.out.println(a.Serialize(node1));
        TreeNode node = a.Deserialize("8!5!7!#!#!9!6!#!#!4!2!#!#!3!#!#!1!10!#!14!#!#!12!#!13!#!#!");
    }
}
