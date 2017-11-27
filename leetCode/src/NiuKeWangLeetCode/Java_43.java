package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_43 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {     //根据二叉树的中序和后序遍历，构造二叉树
        TreeNode node = build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return node;
    }

    public TreeNode build(int[] inorder,int[] postorder,int inBegin,int inEnd,int postBegin,int postEnd){
        int rootVal;
        if(inBegin > inEnd)
            return null;
        rootVal = postorder[postEnd];       //该点为root节点
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for(int i=inBegin;i<=inEnd;i++){
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }
        int leftLength = index - inBegin;       //左子树的长度

        root.left = build(inorder,postorder,inBegin,index-1,postBegin,postBegin+leftLength-1);
        root.right = build(inorder,postorder,index+1,inEnd,postBegin+leftLength,postEnd-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4,6,7,9,2,5,1};
        int[] postorder = {4,7,6,2,1,5,9};
        Java_43 a = new Java_43();
        a.buildTree(inorder,postorder);
    }
}
