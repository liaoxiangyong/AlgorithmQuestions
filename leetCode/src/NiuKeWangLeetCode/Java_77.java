package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/21.
 */
public class Java_77 {
    //双序列动态规划问题，dp[i][j]表示第一个序列i ...和 第二个序列j ...；
    /*
    1. 状态： dp[i][j]表示第一个字符串前i个字符到第二个字符串前j个字符需要的编辑距离；
    2. 递推关系：
　　  (1)如果 s1[i] == s2[j]
　　　　dp[i][j] =dp[i-1][j-1] //表示不需要任何编辑，直接可到达
　　  (2)如果 s1[i] != s2[j],肯定需要进行一次变换
　　　　dp[i][j] = min(dp[i-1][j-1] ,dp[i-1][j],dp[i][j-1]) + 1

    3. 初始化：
　　  dp[i][0] = i; i = 1...m;
　　  dp[0][j] = j; j = 1...n;
     */
    public int minDistance(String word1, String word2) {//从word1转化为word2需要的最小编辑步骤，步骤：删除一个字符、添加一个字符、替换一个字符

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<=word1.length();i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=word2.length();i++){
            dp[0][i] = i;
        }

        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }



    public static void main(String[] args) {
        Java_77 a = new Java_77();
//        a.isSubString("dafadsfa","dafasbdfa");
    }
}
