package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/25.
 */
public class Java_80 {
    public int sqrt(int x) {		//求和x的开方根最接近的整数
        //x的开方根肯定在0-x之间，那么可以使用二分查找
        int start = 0,end = x;
        while(start <=end){
            long mid = (start+end)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if(mid*mid > x){
                end = (int)mid - 1;
            }else{
                start = (int)mid +1;
            }
        }
        return end;
    }

    public static void main(String[] args){
        Java_80 a = new Java_80();
        System.out.println(a.sqrt(15));
    }
}
