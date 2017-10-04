package SwordToOffer;

/**
 * Created by LXY on 2017/9/21.
 */
public class CloneList_25 {

    //输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) return null;
        RandomListNode p1 = pHead;      //老链表

        RandomListNode newListRoot = new RandomListNode(pHead.label);
        RandomListNode newP1 = newListRoot;     //新链表


        //先创建点，按照next
        while(p1.next!=null){
            newP1.next = new RandomListNode(p1.next.label);
            p1 = p1.next;
            newP1 = newP1.next;
        }

        newP1.next = null;      //结尾的位置

        //连接特殊指针random
        RandomListNode p2 = pHead;
        RandomListNode newP2 = newListRoot;
        while(p2!=null){        //遍历链表，为每个点找到random指针指向的点
            RandomListNode p3 = pHead;
            RandomListNode newP3 = newListRoot;
            while(p3!=null){  //遍历链表找到p2指向点的rondom指针
                if(p3 == p2.random){
                    newP2.random = newP3;
                    break;      //跳出循环
                }
                p3 = p3.next;
                newP3 = newP3.next;
            }
            p2 = p2.next;
            newP2 = newP2.next;
        }
        return newListRoot;
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
