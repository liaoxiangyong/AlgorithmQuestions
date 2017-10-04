package SwordToOffer;

/**
 * Created by LXY on 2017/9/19.
 */
public class FindKthToTail_14 {
    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null) return null;
        int listSize = 1;       //记录链表长度
        ListNode p = head;
        while(p.next!=null){
            listSize++;
            p = p.next;
        }

        int count = listSize - k;
        if(count<0) return null;
        ListNode resultNode = head;
        for(int i=0;i<count;i++){
            resultNode = resultNode.next;
        }
        return resultNode;
    }
}
