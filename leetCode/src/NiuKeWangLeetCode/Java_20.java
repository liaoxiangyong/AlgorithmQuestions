package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/10/17.
 */
public class Java_20 {

    //一个字符串分割之后所有子串都是回文，求所有的可能
    public ArrayList<ArrayList<String>> partition(String s) {

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(s==null || s.length() ==0 ) return res;
        //dfs??分割出每一个回文
        DFS(res,new ArrayList<String>(),s);
        return res;
    }


    private void DFS(ArrayList<ArrayList<String>> res ,ArrayList<String> arrayList,String s){
        if(s.length() == 0){
            res.add(new ArrayList<>(arrayList));
            return;
        }
        for(int i = 0;i<s.length();i++){
            String str = s.substring(0,i+1);
            if(isPalindrome(str)){
                arrayList.add(str);
                DFS(res,arrayList,s.substring(str.length()));
                arrayList.remove(arrayList.size()-1);
            }
        }

    }


    private boolean isPalindrome(String s ){        //判断s是否是回文
        for(int i = 0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Java_20 a = new Java_20();
        a.partition1("aabaa");
    }


    //方法二：利用一个二维数组保存字符串的子串是否为回文，这样不用每次都去查找
    public List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s==null || s.length() ==0 ) return res;
        //dfs??分割出每一个回文
        boolean[][] isPalindrome =  new boolean[s.length()][s.length()];        //boolean[i][j]记录i到j是否为回文

        for(int i=0;i<s.length();i++){
            for(int j = 0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2||isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                }
            }
        }
        dfs(isPalindrome,res,new ArrayList<String>(),s,0);
        return res;
    }

    private void dfs( boolean[][] isPalindrome, List<List<String>> res,List<String> list,String s,int pos){
        if(pos == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = pos;i<s.length();i++){
            if(isPalindrome[pos][i]){
                list.add(s.substring(pos,i+1));
                dfs(isPalindrome,res,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
