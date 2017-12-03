package NiuKeWangLeetCode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/12/3.
 */
public class Java_53 {

    public ArrayList<TreeNode> generateTrees(int n) {  //   输出1-n的数能构成二叉搜索树
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        if(n==0) return arrayList;
        return generateTrees(1,n);

    }

    private ArrayList<TreeNode> generateTrees(int left,int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right){
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++){
            ArrayList<TreeNode> lefts = generateTrees(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
            ArrayList<TreeNode> rights = generateTrees(i+1, right);//右子树由[i+1, n]构成
            for (int j = 0; j < lefts.size(); j++){
                for (int k = 0; k < rights.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);//存储所有可能行
                }
            }
        }
        return res;
    }
}
