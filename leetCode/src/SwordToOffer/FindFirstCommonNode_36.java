package SwordToOffer;

/**
 * Created by LXY on 2017/9/25.
 */
public class FindFirstCommonNode_36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        while(p1!=null){
            ListNode p2 = pHead2;
            while(p2!=null){
                if(p1 == p2) return p1;
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return null;
    }
}
