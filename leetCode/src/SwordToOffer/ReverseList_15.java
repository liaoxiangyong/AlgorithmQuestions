package SwordToOffer;

/**
 * Created by LXY on 2017/9/19.
 */
public class ReverseList_15 {

    //输入一个链表，反转链表后，输出链表的所有元素。
    public static ListNode ReverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode next = null;

        while(head!=null){
            next = head.next;          //持有下一个节点的引用
            head.next = pre;           //将当前节点对下一个节点的引用指向前一个节点
            pre = head;                //将前一个节点指向当前节点
            head = next;               //将当前节点指向下一个节点
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ReverseList(node1);
    }
}
