package NiuKeWangLeetCode;

import java.util.*;

/**
 * Created by LXY on 2017/10/9.
 */
public class Java_11 {

    //方法一：直接用dfs超时
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
//        ArrayList<String> result = new ArrayList<>();
//        if(s.length()==0 || wordDict.size()==0) return result;
//        getWords(arrayLists,wordDict,result,s);
//        result.clear();
//        for(int i=0;i<arrayLists.size();i++){
//            StringBuilder a = new StringBuilder();
//            for(int j=0;j<arrayLists.get(i).size();j++){
//                if(j==arrayLists.get(i).size()-1)
//                    a.append(arrayLists.get(i).get(j));
//                else
//                    a.append(arrayLists.get(i).get(j)+" ");
//            }
//            result.add(a.toString());
//        }
//        return result;
//    }
//
//    private void getWords(ArrayList<ArrayList<String>> arrayLists , List<String> dict,ArrayList<String> arrayList,String s){
//        if(s.length() == 0){
//            arrayLists.add(new ArrayList<>(arrayList));
//            return;
//        }
//        for(String word : dict){
//            if(s.startsWith(word)){
//                arrayList.add(word);
//                getWords(arrayLists,dict,arrayList,s.substring(word.length()));
//                arrayList.remove(arrayList.size()-1);
//            }
//        }
//    }

    //方法二，使用一个hashmap保存中间结果
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        List<String> res = DFS(s,dict,new HashMap<String,LinkedList<String>>());
        return new ArrayList<>(res);
    }

    public List<String> DFS(String s,Set<String> dict,HashMap<String,LinkedList<String>> hashMap){
        if(hashMap.containsKey(s)){
            return hashMap.get(s);
        }

        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word : dict){
            if(s.startsWith(word)){
                List<String> subList = DFS(s.substring(word.length()),dict,hashMap);
                for(String sub : subList){
                    res.add(word + (sub.isEmpty()?"":" ")+sub);
                }
            }
        }


        hashMap.put(s,res);
        return res;
    }



    public static void main(String[] args) {
        Java_11 a = new Java_11();
        String[] x = {"a", "aa", "aaa", "aaaa", "aaaaa"};
        Set<String> set = new HashSet<>(Arrays.asList(x));
        ArrayList<String> b = a.wordBreak("aaaaaaaaaaaaaaaaaaa",set);
    }
}
