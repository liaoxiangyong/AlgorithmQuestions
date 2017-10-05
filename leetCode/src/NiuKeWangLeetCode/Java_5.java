package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/5.
 */
public class Java_5 {
    //Sort a linked list using insertion sort.
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode res = new ListNode(0);
        res.next = new ListNode(head.val);
        res.next.next = null;
        ListNode index  = head;
        while(index.next!=null){
            ListNode pre = res;     //插入点前一点
            ListNode p = res.next;       //每次从头开始找
            while(p!=null&&index.next.val>p.val){
                p = p.next;
                pre = pre.next;
            }
            pre.next = new ListNode(index.next.val);
            pre = pre.next;
            pre.next = p;
            index = index.next;
        }

        return res.next;
    }
    public static void main(String[] args) {
        Java_5 a = new Java_5();

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
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;

        ListNode b = a.insertionSortList(node1);


    }
}
