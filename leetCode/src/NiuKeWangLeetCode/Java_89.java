package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/9.
 */
public class Java_89 {

    public ListNode rotateRight(ListNode head, int n) {     //从右到左第n个点进行翻转链表
        if(head == null || n==0) return head;
        int length = 1;     //记录链表有多长
        ListNode p = head;
        while(p.next != null){
            p = p.next;
            length++;
        }
        //此时p指向链表最后一个点
        if(n>length) n=n%length;
        if(n==length || n==0) return head;
        ListNode rotedNode = null;
        ListNode preRotate = head;
        int k=0;
        while(k<length-n-1){
            preRotate = preRotate.next;
            k++;
        }
        rotedNode = preRotate.next;

        preRotate.next = null;
        p.next = head;
        return rotedNode;
    }

    public static void main(String[] args) {
        Java_89 a = new Java_89();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        a.rotateRight(node1,99);
    }
}
