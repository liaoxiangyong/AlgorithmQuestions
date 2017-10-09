package NiuKeWangLeetCode;

import java.util.List;

/**
 * Created by LXY on 2017/10/9.
 */
public class Java_8 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        /**
        //方法一：直接每次查找当前链表的最后一个节点，然后将最后的节点添加到当前遍历到的节点p

         ListNode p = head;
        while(p!=null){
            if(p.next == null) break;
            ListNode last = p;      //保存当前最后的节点
            ListNode pre = null;
            while(last.next!=null){
                pre = last;
                last = last.next;
            }
            if(pre!= null)pre.next = null;
            last.next = p.next;
            p.next = last;
            p = last.next;
        }
         */
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode p = slow.next;
        slow.next = null;       //分成两半，然后后面链表反转，最后合并
        ListNode pre = null;
        while(p!=null){
            ListNode pNext = p.next;
            p.next = pre;
            pre = p;
            p = pNext;
        }

        ListNode first = head;
        //合并前后链表
        while(first!=null && pre!=null){
            ListNode node = first.next;
            first.next = pre;
            ListNode node1 = pre.next;
            pre.next = node;
            first = node;
            pre = node1;
        }
    }

    public static void main(String[] args) {
        Java_8 a = new Java_8();
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
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;


        a.reorderList(node1);
    }
}
