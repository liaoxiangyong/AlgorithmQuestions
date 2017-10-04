package SwordToOffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LXY on 2017/9/29.
 */
public class FirstAppearingOnce_54 {

    //请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
    //输出描述:
    //如果当前字符流没有存在出现一次的字符，返回#字符。

    List<Character> list = new LinkedList<>();      //记录到当前位置出现次数为1的所有字符
    HashSet hashSet = new HashSet();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(list.size()==0) list.add('#');
        if(!hashSet.contains(ch)){
            hashSet.add(ch);
            list.add(ch);
        }else if(hashSet.contains(ch)){      //出现过
            if(list.contains(ch)) list.remove((Object)ch);  //若list还有该ch，直接删除
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return list.size()>1?list.get(1):list.get(0);
    }

    public static void main(String[] args) {
        FirstAppearingOnce_54 a = new FirstAppearingOnce_54();
        a.Insert('B');
        a.Insert('a');
        char x = a.FirstAppearingOnce();
        a.Insert('b');
        a.Insert('y');
        a.Insert('B');
        a.Insert('a');
        x = a.FirstAppearingOnce();
        a.Insert('b');
        a.Insert('y');
        x = a.FirstAppearingOnce();
    }
}
