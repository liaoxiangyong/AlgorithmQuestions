package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/9.
 */
public class Java_10 {

    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
