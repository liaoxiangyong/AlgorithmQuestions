package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/19.
 */
public class Java_69 {

    public int removeDuplicates(int[] nums) {          //给出一个升序数组，删除其中的重复元素，删除之后每个元素最多只能出现两次
        if(nums.length==0) return 0;
        int res = 0;
        int count = 1; //记录连续的数个数
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) {
                count++;
                if(count>2) continue;       //大于两次直接跳过
            }
            else{       //当前数不等于前面的数，那么判断前面的数有几个
                count=1;
            }
            nums[res++] = nums[i];
        }
        return res ;
    }


    //方法二：
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        Java_69 a = new Java_69();
        int[] A = {1,1,1,2,2,3,3,3,3};
        a.removeDuplicates(A);
    }
}
