package SwordToOffer;

/**
 * Created by LXY on 2017/9/30.
 */
public class GetNext_57 {

    //给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        //方法一：找到根节点，然后查找，比较耗时
//        TreeLinkNode head = pNode;
//        while(head.next != null){
//            head = head.next;
//        }
        //然后递归早出对列，然后查找。略

        //该点为叶节点，且为父节点的左节点，下一个为父节点
        //该点为右子节点，找到父节点到祖宗节点中第一个为左节点的父节点，否则下一个点为null
        //节点为非叶子点,那么下一个点为右子树的最左节点
        TreeLinkNode p = pNode;
        if(p.left==null&&p.right==null&&p.next==null)  return null; //只有一个根节点
        if(p.left==null&&p.right==null&&p.next!=null){        //叶子节点
            return ifLeafNode(p);
        }else{          //非根节点
            if(p.right == null){        //右子节点为空
                //将该点左子树置为null，变成叶子节点
                p.left = null;
                if(p.next==null) return null;       //根节点
                return ifLeafNode(p);
            }else{ //下一个节点是右子树的最左节点
                TreeLinkNode temp = p.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                return temp;
            }
        }
//        return pNode;
    }

    public TreeLinkNode ifLeafNode(TreeLinkNode p){
        if(p.next.left==p){     //为父节点的左子节点
            return p.next;
        }else{      //为父节点的右子节点
            if(p.next.next!=null) {     //父节点不为根节点
                //该点父节点为祖父节点的左子节点
                if(p.next.next.left == p.next)
                    return p.next.next;
                else{       //找到父节点到祖宗节点中第一个为左节点的父节点
                    while(p.next!=null&&p.next.next!=null){
                        if(p.next.next.left==p.next){
                            return p.next.next;
                        }
                        p = p.next;
                    }
                }
            }else{      //父节点为根节点
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GetNext_57 a = new GetNext_57();
        TreeLinkNode node1 = new TreeLinkNode(8);
        TreeLinkNode node2 = new TreeLinkNode(5);
        TreeLinkNode node3 = new TreeLinkNode(1);
        TreeLinkNode node4 = new TreeLinkNode(7);
        TreeLinkNode node5 = new TreeLinkNode(9);
        TreeLinkNode node6 = new TreeLinkNode(10);
        TreeLinkNode node7 = new TreeLinkNode(12);
        TreeLinkNode node8 = new TreeLinkNode(6);
        TreeLinkNode node9 = new TreeLinkNode(4);
        TreeLinkNode node10 = new TreeLinkNode(14);
        TreeLinkNode node11 = new TreeLinkNode(13);
        TreeLinkNode node12 = new TreeLinkNode(2);
        TreeLinkNode node13 = new TreeLinkNode(3);

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

        node1.next = null;
        node2.next = node1;
        node3.next = node1;
        node4.next = node2;
        node5.next = node2;
        node6.next = node3;
        node7.next = node3;
        node8.next = node5;
        node9.next = node5;
        node10.next = node6;
        node11.next = node7;
        node12.next = node9;
        node13.next = node9;


        System.out.println(a.GetNext(node11).val);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;       //指向父节点？

    TreeLinkNode(int val) {
        this.val = val;
    }
}
