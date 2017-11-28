package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/28.
 */
public class Java_44 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {          //根据先序遍历和中序遍历构造二叉树
        TreeNode node = build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return node;
    }

    private TreeNode build(int[] preorder, int[] inorder,int preBegin,int preEnd,int inBegin,int inEnd){
        if(inBegin > inEnd)
            return null;
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for(int i=inBegin;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftLength = index - inBegin;
        root.left = build(preorder,inorder,preBegin+1,preBegin+leftLength,inBegin,inBegin + leftLength-1);
        root.right = build(preorder,inorder,preBegin + leftLength +1,preEnd,inBegin+leftLength+1,inEnd);
        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {4,6,7,9,2,5,1};
        int[] preorder = {9,6,4,7,5,2,1};
        Java_44 a = new Java_44();
        a.buildTree(preorder,inorder);
    }
}
