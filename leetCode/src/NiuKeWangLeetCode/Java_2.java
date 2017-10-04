package NiuKeWangLeetCode;

import java.util.Stack;

/**
 * Created by LXY on 2017/10/2.
 */
public class Java_2 {

    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0) return 0;
        Stack<String> stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                stack.push((op2+op1)+"");
            }else if(tokens[i].equals("-")) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                stack.push((op2-op1)+"");
            }else if(tokens[i].equals("*")) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                stack.push((op2*op1)+"");
            }else if(tokens[i].equals("/")) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                stack.push((op2/op1)+"");
            }else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Java_2 a = new Java_2();
        String[] b = {"4", "13", "5", "/", "+"};
        System.out.println(a.evalRPN(b));
    }
}


