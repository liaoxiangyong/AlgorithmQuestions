package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/16.
 */
public class Java_92 {

    public int lengthOfLastWord(String s) {         //找出字符串最后一个单词的长度
        s = s.trim();
        return s.length()-1-s.lastIndexOf(' ');
    }
    public static void main(String[] args) {
        String s = "222";

    }
}
