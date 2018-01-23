package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/18.
 */
public class Java_95 {

    //A[i]表示在i处最多可以跳A[i]步，要求问从第一个元素（index=0）开始，能否达到数组的最后一个元素，这里认为最后一个元素为终点。超过也行
    public boolean canJump(int[] A) {
        if(A.length<1)
            return false;
        if(A.length==1)
            return true;
        int max = 0;        //记录当前能到达的最大点
        for(int i=0;i<A.length-1;i++){
            max = Math.max(max,i+A[i]);
            if(max < i+1){      //到达不了后面的点
                return false;
            }
            if(max >= A.length-1)       //能到达的最大点直接超过最后一个，那么返回true
                return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int reach = nums[0];       //记录从当前点能达到的最大位置
        int lastreach = 0;      //记录前面能到达的最大点
        int step = 0;

        for(int i=1;i<=reach && i<nums.length;i++){
            if(i > lastreach){
                step++;
                lastreach = reach;
            }
            reach = Math.max(reach, i+nums[i]);
        }
        if(reach < nums.length-1) return 0;
        return step;
    }

    public static void main(String[] args) {
        Java_95 a = new Java_95();
        int[] nums = {1};
        a.jump(nums);
    }
}
