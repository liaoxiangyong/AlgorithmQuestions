package NiuKeWangLeetCode;

import java.util.List;

/**
 * Created by LXY on 2017/12/15.
 */
public class Java_63 {

    public ListNode partition(ListNode head, int x) {       //给出一个链表和一个值x，将链表中值小于x的点移动到值大于等于x的点之前，分别需要保持保持两部分中点的相对位置不变
        if(head == null) return head;

        ListNode list1 = new ListNode(0);       //记录小于x的部分
        ListNode list2 = new ListNode(0);       //记录大于等于x的部分
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode node = head;


        while(node!=null){
            int val = node.val;
            if(val>=x){
                p2.next = node;
                p2 = p2.next;
            }else{
                p1.next = node;
                p1 = p1.next;
            }
            node = node.next;
        }
        p2.next = null;
        p1.next = list2.next;
        return list1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
//        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Java_63 a = new Java_63();
        a.partition(node1,3);
    }
}
