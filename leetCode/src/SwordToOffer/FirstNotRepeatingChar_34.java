package SwordToOffer;

/**
 * Created by LXY on 2017/9/25.
 */
public class FirstNotRepeatingChar_34 {

    //在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
    public int FirstNotRepeatingChar(String str) {

        /**
        //方法一：使用hashmap求值，因为hashMap不是按照添加顺序排列的所以需要遍历所有的出现次数为1的然后比较
        int result = Integer.MAX_VALUE;     //保存结果
        boolean isFind = false;
        //遍历，维护一个hashMap，然后遍历hashMap
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map1.containsKey(ch)){
                int count = map1.get(ch);
                map1.remove(ch);
                map1.put(ch,count+1);
            }else{
                map1.put(ch,1);
            }
        }
        Iterator iter =  map1.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            if((int)entry.getValue()==1){
                int index = str.indexOf((char)entry.getKey());
                if(index<result){
                    result = index;
                    isFind = true;
                }
            }
        }
        if(isFind) return result;
        return -1;

        */

        //方法二：比较字符第一次出现和最后一次出现的值是否一样,一样就只出现过一次呗。。。
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int firstIndex = str.indexOf(ch);
            int lastIndex = str.lastIndexOf(ch);
            if(lastIndex==firstIndex) return firstIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar_34 a = new FirstNotRepeatingChar_34();
        System.out.println(a.FirstNotRepeatingChar("google"));
    }
}
