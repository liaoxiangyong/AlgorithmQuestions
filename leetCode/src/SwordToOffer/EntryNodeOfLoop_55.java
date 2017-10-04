package SwordToOffer;

/**
 * Created by LXY on 2017/9/29.
 */
public class EntryNodeOfLoop_55 {

    //一个链表中包含环，请找出该链表的环的入口结点。???
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        //方法一：直接使用一个set辅助
//        ListNode p = pHead;
//        Set<ListNode> set = new HashSet<>();
//
//
//        while(p!=null){
//            if(set.contains(p)){
//                return p;
//            }else{
//                set.add(p);
//                p = p.next;
//            }
//        }


        //方法二：先第一次相遇找到；环前面的路程 = 数个环的长度（为可能为0） + c - a
        if(pHead==null || pHead.next==null || pHead.next.next==null)
            return null;
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;


        while(slow!=fast){
            if(fast.next!=null&& fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                return null;
            }
        }

        //找到相遇的点
        fast = pHead;
        while(slow!=fast){
            if(fast.next!=null&&slow.next!=null){
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }


    public static void main(String[] args) {
        EntryNodeOfLoop_55 a = new EntryNodeOfLoop_55();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node6;

        System.out.println(a.EntryNodeOfLoop(node1).val);
    }
}
