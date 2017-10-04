package SwordToOffer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LXY on 2017/9/19.
 */
public class StackMinVal_20 {

    //定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
    List<Integer>  stack = new LinkedList<Integer>();
    public void push(int node) {
        stack.add(node);;
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int min() {
        List<Integer> stack1 = new LinkedList<Integer>(stack);
        Collections.sort(stack1);
        return stack1.get(0);
    }


    public static void main(String[] args){
        StackMinVal_20 stackMinVal_20 = new StackMinVal_20();
        stackMinVal_20.push(3);
        stackMinVal_20.min();
        stackMinVal_20.push(4);
        stackMinVal_20.min();
        stackMinVal_20.push(2);
        stackMinVal_20.min();
        stackMinVal_20.push(3);
        stackMinVal_20.min();
        stackMinVal_20.pop();
        stackMinVal_20.min();
        stackMinVal_20.pop();
        stackMinVal_20.min();
        stackMinVal_20.pop();
        stackMinVal_20.min();
        stackMinVal_20.push(0);
        stackMinVal_20.min();
    }
}
