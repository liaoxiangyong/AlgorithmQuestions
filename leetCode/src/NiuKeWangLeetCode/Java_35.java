package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/10.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class Java_35 {
    public void connect(TreeLinkNode root) {

        if(root == null) return;
        TreeLinkNode pre = root;        //记录每一层的第一个点
        TreeLinkNode node = pre;       //记录当前遍历到的点
        node.next = null;
        while(pre != null){
            node = pre;
            while(node !=null&& node.left!=null){     //每一层
                node.left.next = node.right;
                if(node.next == null)
                    node.right.next = null;
                else
                    node.right.next = node.next.left;
                node = node.next;
            }
            pre = pre.left;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(9);
        TreeLinkNode node2 = new TreeLinkNode(7);
        TreeLinkNode node3 = new TreeLinkNode(6);
        TreeLinkNode node4 = new TreeLinkNode(3);
        TreeLinkNode node5 = new TreeLinkNode(1);
        TreeLinkNode node6 = new TreeLinkNode(2);
        TreeLinkNode node7 = new TreeLinkNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Java_35 a = new Java_35();
        a.connect(node1);
    }
}
