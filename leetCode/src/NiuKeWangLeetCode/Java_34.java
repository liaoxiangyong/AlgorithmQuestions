package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/10.
 */
public class Java_34 {

    public void connect(TreeLinkNode root) {

        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);       //记录下一层的首节点
            TreeLinkNode curChild = tempChild;  //当前点
            while (root!=null) {     //遍历某一层的节点，并将该层节点的子节点从左到右添加到下一层中去
                if(root.left!=null){
                    curChild.next=root.left;
                    curChild=curChild.next;
                }
                if(root.right!=null){
                    curChild.next=root.right;
                    curChild=curChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;      //将下一层的首节点装载到root，遍历下一层
        }

        //方法二：


//        while(pre !=null){
//            node = pre;
//
//            TreeLinkNode nextPre = null;        //下一层的起始点
//            while(node!=null && nextPre == null){
//                if(node.left!=null){
//                    nextPre = node.left;
//                }else if(node.right !=null){
//                    nextPre = node.right;
//                }else{
//                    node = node.next;
//                }
//            }
//            TreeLinkNode node1 = null;      //找到下一层的next，node指向node1
//            TreeLinkNode node2 = null;
//            while(node!=null){
//                while(node1==null){
//                    if(node.left!=null)
//                        node1 = node.left;
//                    else if(node.right!=null)
//                        node1 = node.right;
//                    else
//                        node = node.next;
//                }
//                if(node1 != null ){     //找到了前集结点，那么查找node1的next节点
//                    if((node.left == node1 && node.right ==null)||node.right == node1) node = node.next;        //有左节点但是无右节点 或者 node1为右节点，那么在node向后移动
//                    if(node !=null && node.left == node1 && node.right !=null){        //右节点不为空，node2为右节点，然后查找下一点
//                        node2 = node.right;
//                        node = node.next;
//                    }
//                    while(node !=null && node2==null){
//                        if(node.left!=null)
//                            node2 = node.left;
//                        else if(node.right!=null)
//                            node2 = node.right;
//                        else
//                            node = node.next;
//                    }
//                }
//                node1.next = node2;
//                if(node !=null &&(node2 ==node.right || (node.left == node2 && node.right == null)))  node = node.next;
//                node1 = node2;
//                node2 = null;
//            }
//
//            pre = nextPre;

    }
    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(0);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(3);
        TreeLinkNode node5 = new TreeLinkNode(3);
        TreeLinkNode node6 = new TreeLinkNode(1);
        TreeLinkNode node7 = new TreeLinkNode(5);
        TreeLinkNode node8 = new TreeLinkNode(1);
        TreeLinkNode node9 = new TreeLinkNode(6);
        TreeLinkNode node10 = new TreeLinkNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left=node7;
        node4.right = node8;
        node5.right = node9;
        node6.right = node10;


        Java_34 a = new Java_34();
        a.connect(node1);
    }
}
