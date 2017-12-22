package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by LXY on 2017/12/22.
 */
public class Java_78 {

    public String simplifyPath(String path) {      //给出一个unix的绝对路径，简化路径，.表示当前目录，../表示上级目录
        if(path.equals("/"))
            return path;
        String[] strings = path.split("/");
        Stack<String > stack  = new Stack<>();
        for(int i=0;i<strings.length;i++){
            if(strings[i].equals("") || strings[i].equals("."))
                continue;
            else if(strings[i].equals("..")){
                if(stack.size()>0)
                    stack.pop();
            }else
                stack.push(strings[i]);
        }
        if(stack.isEmpty())
            return "/";
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Java_78 a = new Java_78();
        a.simplifyPath("/home/../../..");
    }
}
