package NiuKeWangLeetCode;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/12/8.
 */
public class Java_60 {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if(n==0) { res.add(0); return  res;}
        String[] gray = grayCode1(n);
        for(int i=0;i<gray.length;i++){
            String temp = gray[i];
            Integer sum =0;
            for(int j=temp.length()-1;j>=0;j--){
                sum += (temp.charAt(j)-'0') * (1<<(temp.length()-1-j));
            }
            res.add(sum);
        }
        return res;
    }

    public String[] grayCode1(int n) {
        String[] gray = new String[(int)Math.pow(2,n)];
        if(n==1){
            gray[0] = "0";
            gray[1] = "1";
            return gray;
        }
        String[] last = grayCode1(n-1);
        for(int j=0;j<last.length;j++){
            gray[j] = "0" + last[j];
            gray[gray.length-1-j] = "1" +last[j];
        }
        return gray;
    }

    public static void main(String[] args) {
        Java_60 a = new Java_60();
        a.grayCode(0);
    }

}
