package SwordToOffer;

import java.util.Stack;

/**
 * Created by LXY on 2017/9/17.
 */
public class StackToQueue_5 {

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int size = stack1.size();
        for(int i=0;i<size-1;i++){
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        for(int i=0;i<size-1;i++){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args){
        StackToQueue_5 stackToQueue_5 = new StackToQueue_5();
        stackToQueue_5.push(1);
        stackToQueue_5.push(2);
        stackToQueue_5.push(3);
        System.out.println(stackToQueue_5.pop());
        System.out.println(stackToQueue_5.pop());
        stackToQueue_5.push(4);
        System.out.println(stackToQueue_5.pop());
        stackToQueue_5.push(5);
        System.out.println(stackToQueue_5.pop());
        System.out.println(stackToQueue_5.pop());
    }
}
