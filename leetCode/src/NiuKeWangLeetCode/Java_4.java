package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/2.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}

public class Java_4 {
    //Sort a linked list in O(n log n) time using constant space complexity.
    public ListNode sortList(ListNode head) {
        if(head == null)  return null;
        return sort(head);
    }


    public ListNode sort(ListNode head){
        ListNode slow = head;       //找到链表的中点
        ListNode fast = head;

        if(head==null||head.next==null) return head;
        while(slow.next!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sort(head);
        ListNode right = sort(mid);
        head = merge(left,right);
        return head;
    }

    public ListNode merge( ListNode left , ListNode right){
        ListNode node = new ListNode(0);
        ListNode res = node;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                node.next = left;
                node = node.next;
                left = left.next;
            }else{
                node.next = right;
                node = node.next;
                right = right.next;
            }
        }

        while(left!=null){
            node.next = left;
            node = node.next;
            left = left.next;
        }


        while(right!=null){
            node.next = right;
            node = node.next;
            right = right.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Java_4 a = new Java_4();

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode b = a.sortList(node1);


    }
}
