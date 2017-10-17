package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/17.
 */
public class Java_19 {
    public int minCut(String s) {
        //方法一：找出每种可能，然后找到分割次数最少的方法
        //方法二：利用动态规划，查找到当前点最小分割次数
        int[] cut = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            int min = i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    min = j==0?0:Math.min(min,cut[j-1]+1);
                }
            }
            cut[i] = min;
        }

        return cut[s.length()-1];
    }

    public static void main(String[] args) {
        Java_19 a = new Java_19();
        a.minCut("cdd");
    }
}
