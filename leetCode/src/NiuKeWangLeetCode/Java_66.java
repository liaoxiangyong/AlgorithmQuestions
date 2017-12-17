package NiuKeWangLeetCode;

import java.util.List;

/**
 * Created by LXY on 2017/12/17.
 */
public class Java_66 {
    public ListNode deleteDuplicates(ListNode head) {  //删掉升序链表中的有重复的节点
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode node = head;
        ListNode preNode = null;        //记录当前点的前一个点
        ListNode nextNode = null;       //记录当前点的后一个点

        while(node !=null){
            nextNode = node.next;
            if(preNode==null){      //第一个点
                if(nextNode ==null || (nextNode.val != node.val)){      //只有一个点的情况或者只有第一个点和后一个点不相同，加入对列
                    p.next = node;
                    p = p.next;
                }
            }else{
                //（1）如果是最后一个点，那么如果该点和前面点不一样加入链表，（2）或者中间点，和前后的值都不一样加入链表
                if((nextNode == null && (preNode.val!=node.val)) || (nextNode !=null && nextNode.val != node.val && (preNode.val!=node.val))){
                    p.next = node;
                    p = p.next;
                }
            }
            preNode = node;
            node = nextNode;
        }
        p.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        Java_66 a = new Java_66();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        a.deleteDuplicates(node1);
    }
}
