package NiuKeWangLeetCode;

/**
 * Created by LXY on 2018/1/23.
 */
public class Java_97 {

    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max = nums[0];
        int sum = nums[0];  //用来记录当前最大值
        for(int i=1;i<nums.length;i++){
            sum = Math.max(nums[i],nums[i]+sum);
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Java_97 a = new Java_97();
        a.maxSubArray(nums);
    }
}
