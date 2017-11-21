package NiuKeWangLeetCode;

import java.util.List;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_40 {
    public TreeNode sortedListToBST(ListNode head) {   //将一个有序二叉树变为二叉搜索树
        TreeNode node = createTree(head,null);
        return node;
    }

    public TreeNode createTree(ListNode head, ListNode end){
        if(head == end)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= end && fast.next !=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);

        root.left = createTree(head,slow);
        root.right = createTree(slow.next,end);
        return root;
    }

    public static void main(String[] args) {
        Java_40 a = new Java_40();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(12);
        ListNode node6 = new ListNode(22);
        ListNode node7 = new ListNode(29);
        ListNode node8 = new ListNode(51);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        a.sortedListToBST(node1);
    }
}
