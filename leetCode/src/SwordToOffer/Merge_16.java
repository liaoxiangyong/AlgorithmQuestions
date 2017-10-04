package SwordToOffer;

/**
 * Created by LXY on 2017/9/19.
 */
public class Merge_16 {

    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(0);
        ListNode node = result;
        ListNode p = list1;
        ListNode q = list2;
        if(p==null) return q;
        if(q==null) return p;

        while(p!=null&&q!=null){
            if(p.val<=q.val){
                node.next = p;
                p = p.next;
            }else{
                node.next = q;
                q = q.next;
            }
            node = node.next;
        }
        if(q!=null){
            node.next = q;
        }
        if(p!=null){
            node.next = p;
        }

        return result.next;
    }
}
