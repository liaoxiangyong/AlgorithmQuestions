package SwordToOffer;

import java.util.Stack;

/**
 * Created by LXY on 2017/9/20.
 */
public class IsPopOrder_21 {

    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);       //入栈
        int j=1;
        for(int i =0;i<popA.length;i++){
            while(j<pushA.length&&stack.peek()!=popA[i]){       //每次栈顶元素和当前需要弹出元素比较，不相等就继续入栈
                stack.push(pushA[j]);
                j++;
            }
            //相等就弹出栈顶元素
            if(stack.peek()==popA[i])
                stack.pop();
        }
        if(stack.size()==0) return true;
        return false;
    }

    public static void main(String[] args){
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
