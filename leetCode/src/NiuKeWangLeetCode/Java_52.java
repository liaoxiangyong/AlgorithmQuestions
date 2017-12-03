package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/3.
 */
public class Java_52 {
    public boolean isInterleave(String s1, String s2, String s3) {   //判断能否有s1和s2按顺序交叉组合成s3
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] path = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0;i<=s1.length();i++){
            for (int j=0;j<=s2.length();j++){
                if(i==0&&j==0)
                    path[i][j] = true;
                else if(i==0){
                    path[i][j] = path[i][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
                }else if(j==0){
                    path[i][j] = path[i-1][j] && (s1.charAt(i-1) == s3.charAt(i-1));
                }else{
                    path[i][j] = (path[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))) || (path[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
                }
            }
        }
        return path[s1.length()][s2.length()];
    }

    private boolean interleave(String s1, String s2, String s3,int i,int j,int k){  //这里直接用深度查找法，会超时。
        if(i==s1.length() && j==s2.length() && k == s3.length())
            return true;
        if(i<s1.length() && j<s2.length()){
            if( s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
                return interleave(s1,s2,s3,i+1,j,k+1) || interleave(s1,s2,s3,i,j+1,k+1);
            }
            if(s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k))
                return false;
            if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) != s3.charAt(k))
                return interleave(s1,s2,s3,i+1,j,k+1);
            return interleave(s1,s2,s3,i,j+1,k+1);
        }else if(i<s1.length() && j>=s2.length() && s1.charAt(i) == s3.charAt(k)){
            return interleave(s1,s2,s3,i+1,j,k+1);
        }else if(i>=s1.length() && j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            return interleave(s1,s2,s3,i,j+1,k+1);
        }else
            return false;
    }

    public static void main(String[] args) {
        Java_52 a  = new Java_52();
        System.out.println(a.isInterleave("","",""));
    }
}
