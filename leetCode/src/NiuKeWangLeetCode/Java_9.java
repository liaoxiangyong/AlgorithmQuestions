package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/9.
 */
public class Java_9 {

    //寻找链表环的入口
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while( fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        if(fast==null || fast.next == null) return null;
        ListNode p = slow;
        ListNode start = head;

        while(p!=start){
            p = p.next;
            start = start.next;
        }

        return start;
    }

    public static void main(String[] args) {
        Java_9 a = new Java_9();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node2.next = node1;

        a.detectCycle(node1);
    }
}
