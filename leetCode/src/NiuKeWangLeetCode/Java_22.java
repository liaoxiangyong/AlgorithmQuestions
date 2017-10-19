package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/10/19.
 */
public class Java_22 {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();


        findNum(list,stringBuilder,root);

        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += Integer.parseInt(list.get(i));
        }

        return sum;
    }


    private void findNum(List<String> list,StringBuilder stringBuilder,TreeNode node){
        if(node.left == null && node.right==null){      //叶子节点
            stringBuilder.append(""+node.val);
            list.add(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            return;
        }
        stringBuilder = stringBuilder.append(node.val+"");
        if(node.left != null){
            findNum(list,stringBuilder,node.left);
        }

        if(node.right != null){
            findNum(list,stringBuilder,node.right);
        }
        stringBuilder = stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());      //因为node.val长度为1，直接删除最后一位数
    }

    public static void main(String[] args) {
        Java_22 a = new Java_22();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        a.sumNumbers(node1);
    }

}
