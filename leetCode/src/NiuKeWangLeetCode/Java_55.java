package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by LXY on 2017/12/4.
 */
public class Java_55 {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {         //使用非递归实现中序遍历
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node =  root;
        while(!stack.isEmpty() || node !=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node=stack.pop();
                result.add(node.val);       //出栈的时候添加
                node=node.right;
            }
        }
        return result;
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {         //使用非递归实现先序遍历
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node =  root;
        while(!stack.isEmpty() || node !=null){
            if(node!=null){  //入栈的时候添加
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }else{
                node=stack.pop();
                node=node.right;
            }
        }
        return result;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {         //使用非递归实现后序遍历
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node =  root;
        while(!stack.isEmpty() || node !=null){
            if(node!=null){  //入栈的时候添加
                stack.push(node);
                result.add(node.val);
                node = node.right;
            }else{
                node=stack.pop();
                node=node.left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Java_55 a = new Java_55();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);

        node1.left  = node2;
        node1.right = node3;
        node3.left = node4;

        a.postorderTraversal(node1);
    }
}
