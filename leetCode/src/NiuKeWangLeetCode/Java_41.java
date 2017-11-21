package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_41 {

    public TreeNode sortedArrayToBST(int[] num) {       //将一个有序数组变成一棵高度平衡二叉搜索树
        return create(0,num.length-1,num);
    }

    public TreeNode create(int start,int end,int[] num){
        if(start>end) return null;
        int middle = (start + end)/2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = create(start,middle-1,num);
        root.right = create(middle+1,end,num);
        return root;
    }

    public static void main(String[] args) {
        Java_41 a = new Java_41();

        int[] num = {1,5,7,8,12,34,67,88,99};
        TreeNode node = a.sortedArrayToBST(num);
    }
}
