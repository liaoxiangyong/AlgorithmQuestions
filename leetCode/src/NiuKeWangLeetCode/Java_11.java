package NiuKeWangLeetCode;

import java.util.*;

/**
 * Created by LXY on 2017/10/9.
 */
public class Java_11 {
//    ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
//    Set<String> dict;
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        ArrayList<String> result = new ArrayList<>();
//        if(s.length()==0 || dict.size()==0) return result;
//        this.dict = dict;
//        getWords(result,s);
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
//    private void getWords(ArrayList<String> arrayList,String s){
//        if(s.length() == 0){
//            arrayLists.add(new ArrayList<>(arrayList));
//            return;
//        }
//        for(String word : dict){
//            if(s.startsWith(word)){
//                arrayList.add(word);
//                getWords(arrayList,s.substring(word.length()));
//                arrayList.remove(arrayList.size()-1);
//            }
//        }
//    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    List<String> DFS(String s,List<String> wordDict,HashMap<String,LinkedList<String>> map){
        if(map.containsKey(s))
            return map.get(s);
        LinkedList<String> res = new LinkedList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> subList = DFS(s.substring(word.length()),wordDict,map);
                for(String sub : subList){
                    res.add(word + (sub.isEmpty() ? "":" ")+ sub);
                }
            }
        }
        map.put(s,res);
        return res;
    }



    public static void main(String[] args) {
        Java_11 a = new Java_11();
        String[] x = {"a", "aa", "aaa", "aaaa", "aaaaa"};
        List<String> set = Arrays.asList(x);;
//        a.wordBreak("aaaaaaaaaaaaaaaaaaa",set);
    }
}
