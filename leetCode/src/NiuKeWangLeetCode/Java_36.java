package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/11/21.
 */
public class Java_36 {

    public int numDistinct(String s, String t) {
        int[][] men = new int[s.length()+1][t.length()+1];      //men[i][j]代表s从开始位置到i,t从开始位置到j 子串匹配的个数,可以得到men[i][j]>=men[i-1][j]

        //当i为0，即s子串为空的时候，men[i][j]==0
        for(int j=0;j<t.length();j++){
            men[0][j] =0;
        }
        //当j=0，即t子串为空，men[i][j]=1
        for (int i=0;i<s.length();i++){
            men[i][0] = 1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                men[i][j] = men[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)){
                    men[i][j] += men[i-1][j-1];
                }
            }
        }
        return men[s.length()][t.length()];
    }
}
