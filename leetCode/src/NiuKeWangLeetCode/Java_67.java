package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/17.
 */
public class Java_67 {
    public ListNode deleteDuplicates(ListNode head) {       //链表升序排列，删掉重复链表中的重复节点
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Java_67 a = new Java_67();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(5);
//        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        a.deleteDuplicates(node1);
    }
}




