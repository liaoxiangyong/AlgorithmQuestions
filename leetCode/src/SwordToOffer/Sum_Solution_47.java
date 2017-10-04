package SwordToOffer;

/**
 * Created by LXY on 2017/9/27.
 */
public class Sum_Solution_47 {

    //求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {

        int sum = n;

        boolean a = (n>0)&& (sum += Sum_Solution(n-1))>0;
        return sum;
    }

    public static void main(String[] args){
        Sum_Solution_47 a = new Sum_Solution_47();
        System.out.println(a.Sum_Solution(100));
    }
}
