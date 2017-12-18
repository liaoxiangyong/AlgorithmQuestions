package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/18.
 */
public class Java_100 {
    public int search(int[] nums, int target) {        //一个升序数组在某个点被翻转过，判断target在数组中的位置，若不存在返回-1,链表中不含重复的数
        //方法一：暴力求解，直接遍历数组，时间复杂度为o(n)

        //可以只用一次二分查找得到结果,时间复杂度为o(logn),因为链表只有一个地方被翻转了，那么肯定可以知道链表若从中间分为两半，一边是肯定有序的；（1）若左边有序，如果target在左边范围，那么继续查找，否则在另一边查找；（2）若右边有序，如果target在右边范围，继续查找，否则在左边查找
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[start] <= nums[mid]){            //如果链表左边是有序的
                if(nums[start] <= target && target < nums[mid]){            //若target在链表左边
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

            } else{     //否则，如果链表右边是有序的
                if(nums[end] >= target && target > nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Java_100 a  = new Java_100();
        int[] b = {3,1};
        a.search(b,1);
    }
}
