package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/9.
 */
public class Java_85 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {       //将两个有序链表合并成一个新链表
        ListNode res = new ListNode(0);
        ListNode p = res;

        while(l1 != null && l2 !=null){
            if(l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if(l1!=null){
            p.next = l1;
        }
        if (l2 != null){
            p.next = l2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Java_85 a = new Java_85();

    }
}
