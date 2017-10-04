package SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by LXY on 2017/9/17.
 */
public class TraceList_3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if(listNode==null)
            return resultList;
        while(listNode!=null){
            resultList.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(resultList);
        return resultList;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
    this.val = val;
    }
}
