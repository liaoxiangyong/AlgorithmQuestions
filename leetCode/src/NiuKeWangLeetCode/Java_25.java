package NiuKeWangLeetCode;

import java.util.*;

/**
 * Created by LXY on 2017/10/22.
 */
public class Java_25 {

    //方法一：找到每个字符相差为1的数组，然后查找，超时，这里相当于是使用的dfs深度查找
//    public int ladderLength(String begin, String end, List<String> dict) {
//        HashMap<String,List<String>> hashMap = new HashMap<>();       //用来保存dict中每个字符串中只差一个字符的数
//        HashSet<String> hashSet = new HashSet<>();      //保存已经被访问过的字符串
//        hashMap.put(begin,new ArrayList<>());
//        for(int i=0;i<dict.size();i++)    //查找begin只差一个字符的
//            if(onlyOneWorld(dict.get(i),begin))
//                hashMap.get(begin).add(dict.get(i));
//        for(int i=0;i<dict.size();i++){     //查找word中相差一个字符的，包含end
//            List<String> list = new ArrayList<>();
//            hashMap.put(dict.get(i),list);
//            for(int j=0;j<dict.size();j++)
//                if(onlyOneWorld(dict.get(i),dict.get(j))){
//                    hashMap.get(dict.get(i)).add(dict.get(j));
//                }
//        }
//        int[] res = new int[1];     //记录最短长度
//        res[0] = Integer.MAX_VALUE;
//        findLadderLength(res,hashMap,hashSet,end,begin,1);
//        return res[0] == Integer.MAX_VALUE ? 0:res[0];
//    }
//    private void findLadderLength(int[] res,HashMap<String,List<String>> hashMap,HashSet<String> hashSet,String end,String nowWord,int count) {
//        if (nowWord.equals(end)) {
//            res[0] = Math.min(res[0], count);
//            return;
//        }
//        List<String> list = hashMap.get(nowWord);
//        hashSet.add(nowWord);
//        for (int i = 0; i < list.size(); i++)
//            if (!hashSet.contains(list.get(i)))
//                findLadderLength(res, hashMap, hashSet, end, list.get(i), count + 1);
//        hashMap.remove(nowWord);
//    }
//    private boolean onlyOneWorld(String s1,String s2){  //判断两个字符串是否只有一个字符不一样
//        int count = 0;
//        for(int i=0;i<s1.length();i++){
//            if(s1.charAt(i) != s2.charAt(i))
//                count++;
//        }
//        return count==1?true:false;
//    }


    //方法二：使用BFS，这样对每一层每种可能都遍历过，这样当发现等于end时，就可以直接返回结果。
//    public int ladderLength(String begin, String end, List<String> dict) {
//        HashSet<String> hashSet = new HashSet<>();  //用来保存已经使用过的word
//        Queue<String> queue = new LinkedList<>();       //用来进行帮助进行BFS
//        queue.add(begin);
//        queue.add(null);        //用来标记每一层结束，也可以用size或者在创建queue
//        hashSet.add(begin);
//        int level = 1;      //用来记录最短的到达方法
//        while(!queue.isEmpty()){
//            String now = queue.poll();
//            if(now != null){
//                for(int i=0;i<dict.size();i++){
//                    if(onlyOneWorld(now,dict.get(i))){      //加入下一层的所有的可能情况
//                        if(!hashSet.contains(dict.get(i))){
//                            if(dict.get(i).equals(end))
//                                return level+1;
//                            hashSet.add(dict.get(i));
//                            queue.add(dict.get(i));
//                        }
//                    }
//                }
//            }else{  //遍历完一层
//                level++;
//                if (!queue.isEmpty()) {
//                    queue.add(null);
//                }
//            }
//        }
//        return 0;
//    }

    private boolean onlyOneWorld(String s1,String s2){  //判断两个字符串是否只有一个字符不一样
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count==1?true:false;
    }



    //方法三：使用一个beginSet和endSet这样可以缩短查询时间，从begin和从end开始，如果begin下一个可能在end中，那么直接可以达到
    public int ladderLength(String begin, String end, HashSet<String> dict) {
        if(!dict.contains(end)) return 0;
        HashSet<String> hashSet = new HashSet<>();  //用来保存已经使用过的word
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        beginSet.add(begin);
        endSet.add(end);

        int level = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){      //每次查找较小的
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            HashSet<String> temp = new HashSet<>();
            for(String str : beginSet){
                Iterator iterator = dict.iterator();
                while (iterator.hasNext()){
                    String a = (String) iterator.next();
                    if(onlyOneWorld(str,a)&&endSet.contains(a))
                        return level + 1;
                    if(!hashSet.contains(a) && onlyOneWorld(str,a)){        //未被访问过
                        hashSet.add(a);
                        temp.add(a);
                    }
                }
            }
            beginSet = temp;
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Java_25 a = new Java_25();
        String begin = "hit";
        String end = "cog";
        String[] dict = {"hot","dot","dog","lot","log","cog"};
        a.ladderLength(begin,end, new HashSet<>(Arrays.asList(dict)));
    }
}
