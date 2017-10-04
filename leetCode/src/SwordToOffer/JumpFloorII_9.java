package SwordToOffer;

/**
 * Created by LXY on 2017/9/18.
 */
public class JumpFloorII_9 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int JumpFloorII(int target) {
        if(target==0) return 0;

        return JumpFloor(target);
    }

    public static int JumpFloor(int target){
        if(target==0) return 1;
        if(target==1) return 1;
        if(target==2) return 2;
        int count = 0;
        for(int i=0;i<=target-1;i++){
            count += JumpFloor(i);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(JumpFloorII(3));
    }
}
