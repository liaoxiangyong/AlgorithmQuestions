package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/6.
 */
public class Java_57 {

    public ListNode reverseBetween(ListNode head, int m, int n) {           //反转链表从m到n的节点，其中1 ≤ m ≤ n ≤ length of list
        if(m==n) return head;
        ListNode startNode = head; //记录m-1的点
        ListNode preNode = head;        //记录当前点的前一个点
        ListNode nextNode = null; //记录当前点的下一个点
        ListNode node = head;
        int index = 1;
        if(m==1){       //第一个点开始翻转
            while(index <= n){
//                node = node.next;
                nextNode = node.next;       //记录下一个点
                if(index !=1){      //不是第一个点就交换指针
                    node.next = preNode;
                    preNode = node;
                }
                node = nextNode;
                index++;
            }
            startNode.next = node;
            return preNode;
        }else{      //后面点开始翻转
            ListNode temp = null;
            while(index <=n){
                if(index == m-1) {      //记录翻转点前一个点
                    startNode = node;
                    temp = node.next;
                }
                nextNode = node.next;       //记录下一个点
                if(index !=1 && index > m){      //不是第一个点就交换指针
                    node.next = preNode;
                }
                preNode = node;
                node = nextNode;
                index++;
            }
            startNode.next = preNode;
            temp.next = node;
            return head;
        }
    }

    public static void main(String[] args) {
        Java_57 a = new Java_57();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        a.reverseBetween(node1,4,5);
    }
}
