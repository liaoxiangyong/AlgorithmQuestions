package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/7.
 */
public class Java_59 {

    public int numDecodings1(String s) {         //给出一个字母数字对应表，将一个数字，转码成可能的字符串
        if(s.length() ==0) return 0;
        int[] count = new int[s.length()];      //count[i]记录从开始到i点有count[i]中可能的编码方式
        int first = s.charAt(0)-'A'+1;
        if(first<=9 && first >=1) count[0] = 1;
        else count[0] = 0;
        if(s.length()>1){
            int second = s.charAt(1)-'A'+1;
            int sum = first * 10 +second;
            if(sum >26){
                if(count[0]==0) return 0;
                else{
                    if(second<=9 && second >=1)
                        count[1] = 1;
                    else
                        return 0;
                }
            }else{
                if(count[0]==0) return 0;
                else{
                    if(second<=9 && second >=1)
                        count[1] = 2;
                    else
                        count[1] =1;
                }
            }
        }
        for(int i=2;i<s.length();i++){
            int value = s.charAt(i) - 'A'+1;
            int pre = s.charAt(i-1)-'A'+1;
            int sum = pre* 10 +value;

            if(sum <=26 && pre!=0){
                count[i] = count[i-2];
            }
            if(value >=1 && value<=9)
                count[i] += count[i-1];
        }
        return count[s.length()-1];
    }


    public int numDecodings(String s) {     //数字编码成字母的方式
        if(s.length() ==0) return 0;
        int[] count = new int[s.length()];      //count[i]记录从开始到i点有count[i]中可能的编码方式

        int first = Integer.parseInt(s.charAt(0)+ "");
        if(first>=1 && first<=9) count[0]=1;
        else count[0] = 0;

        if(s.length() >1){
            int second = Integer.parseInt(s.charAt(1)+ "");
            int sum = first * 10 +second;
            if(sum >26){
                if(count[0]==0) return 0;
                else{
                    if(second<=9 && second >=1)
                        count[1] = 1;
                    else
                        return 0;
                }
            }else{
                if(count[0]==0) return 0;
                else{
                    if(second<=9 && second >=1)
                        count[1] = 2;
                    else
                        count[1] =1;
                }
            }
        }
        for(int i=2;i<s.length();i++){
            int value = Integer.parseInt(s.charAt(i)+"");
            int pre =  Integer.parseInt(s.charAt(i-1)+"");
            int sum = pre* 10 +value;

            if(sum <=26 && pre!=0){
                count[i] = count[i-2];
            }
            if(value >=1 && value<=9)
                count[i] += count[i-1];
        }
        return count[s.length()-1];
    }

    public int numDecodings2(String s) {        //优化
        if(s.length() ==0) return 0;
        int[] count = new int[s.length()+1];      //count[i]记录从开始到i-1点有count[i]中可能的编码方式
        count[0]=1;
        if(s.charAt(0)>'0')
            count[1]=1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)>='1')
                count[i] = count[i-1];
            int sum = Integer.parseInt(s.substring(i-2,i));
            if(sum <=26 && s.charAt(i-2)!='0' )
                count[i] += count[i-2];
        }
        return count[s.length()];
    }
        public static void main(String[] args) {
        Java_59 a = new Java_59();
        System.out.println(a.numDecodings2("12"));
    }
}
