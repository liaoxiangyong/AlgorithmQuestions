package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/15.
 */
public class Java_62 {

    public boolean isScramble(String s1, String s2) {  //如果s2是s1的scramble串，那么必然存在一个在s1上的长度l1，将s1分成s11和s12两段，同样有s21和s22。那么只有两种可能：（1）s11和s21是scramble且s12和s22是scramble （2）s11和s22是scramble且s12和s21是scramble
        if (s1.equals(s2)) return true;

        int length = s1.length();
        int[] count = new int[26];
        for(int i=0;i<length;i++){
            count[s1.charAt(i)-'a'] ++;
            count[s2.charAt(i)-'a'] --;
        }
        for(int i=0; i<26; i++) {
            if(count[i]!=0)
                return false;
        }

        for(int i=1;i<length;i++){
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(length-i))
                    && isScramble(s1.substring(i), s2.substring(0,length-i))) return true;
        }
        return false;
    }
}
