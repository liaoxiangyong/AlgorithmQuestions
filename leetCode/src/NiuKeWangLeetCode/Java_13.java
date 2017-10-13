package NiuKeWangLeetCode;

import java.util.HashMap;

/**
 * Created by LXY on 2017/10/11.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class Java_13 {
    public RandomListNode copyRandomList(RandomListNode head) {

        //方法一：直接先复制找到next指针，然后查找每个点的random
//        RandomListNode result = new RandomListNode(0);
//        RandomListNode pNew = result;
//        RandomListNode pOld  = head;
//
//        while(pOld!=null){      //先找到next指针
//            pNew.next = new RandomListNode(pOld.label);
//            pNew = pNew.next;
//            pOld = pOld.next;
//        }
//
//
//        //对于每个点的random指针都从头遍历到尾查找
//        RandomListNode p = result.next;
//        RandomListNode q = head;
//        while(p!=null){
//            RandomListNode find = head;
//            RandomListNode set = result.next;
//            while(find!=null && find != q.random){
//                find = find.next;
//                set = set.next;
//            }
//            p.random = set;
//
//            p = p.next;
//            q = q.next;
//        }
//        return result.next;


//        //方法二：o(n)，使用一个hashMap来保存和对应原链表的点和新链表的点
//        if(head == null) return null;
//
//        HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<>();
//
//        RandomListNode node = head;
//
//        while(node != null){        //先创建点
//            hashMap.put(node,new RandomListNode(node.label));
//            node = node.next;
//        }
//
//        //赋值next指针和random指针
//        node = head;
//        while(node!=null){
//            hashMap.get(node).next = hashMap.get(node.next);
//            hashMap.get(node).random = hashMap.get(node.random);
//            node = node.next;
//        }
//
//        return hashMap.get(head);



        //方法三：o(n)时间复杂度，o(1)的空间复杂度
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}
