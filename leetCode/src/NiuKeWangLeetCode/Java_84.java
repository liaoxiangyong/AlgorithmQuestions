package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/8.
 */
public class Java_84 {

    public String addBinary(String a, String b) {       //字符串表示的两个二进制数相加

        String temp = "";
        int i = a.length()-1,j=b.length()-1;
        int count = 0;
        while(i>=0&& j>=0){
            count = count + (a.charAt(i)-'0') + (b.charAt(j)-'0');
            if(count > 1){
                temp = ((count)%2) + temp;
                count = 1;
            }else{
                temp = count + temp;
                count = 0;
            }
            i--;
            j--;
        }
        //a长一些
        while(i>=0){
            count += a.charAt(i)-'0';
            if(count > 1){
                temp = ((count)%2) + temp;
                count = 1;
            }else{
                temp = count + temp;
                count = 0;
            }
            i--;
        }
        //b长一些
        while(j>=0){
            count += b.charAt(j)-'0';
            if(count > 1){
                temp = ((count)%2) + temp;
                count = 1;
            }else{
                temp = count + temp;
                count = 0;
            }
            j--;
        }
        if(count == 1)
            temp = count + temp;
        return temp;
    }

    public static void main(String[] args) {
        Java_84 a = new Java_84();
        a.addBinary("","111");
    }
}
