package SwordToOffer;

/**
 * Created by LXY on 2017/9/29.
 */
public class DeleteDuplication_56 {

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) return null;
        if(pHead.next == null) return pHead;

        ListNode result = new ListNode(0);
        ListNode node =result;
        ListNode p = pHead.next;
        ListNode pre = pHead;       //当前点前一个点
        ListNode next = null;     //当前点后一个点

        if(pre.val!=p.val) {
            result.next = pre;
            result = result.next;
        }
        while(p!=null){
            if(p.next!=null) {      //如果当前有后节点
                next = p.next;
                if(p.val!=next.val&&p.val!=pre.val){        //当前点和前后节点都不相等
                    result.next = p;
                    result = result.next;
                }
                pre = p;
                p = p.next;
            }else{      //没有后节点
                if(p.val != pre.val){       //不相等
                    result.next = p;
                    result = result.next;
                }
                p = p.next;     //这里是null
            }
        }
        result.next = null;
        return node.next;
    }


    public static void main(String[] args) {
        DeleteDuplication_56 a = new DeleteDuplication_56();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
//        ListNode node8 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;
        ListNode b = a.deleteDuplication(node1);
    }
}
