package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/18.
 */
public class Java_68 {
    public boolean search(int[] nums, int target) {         //一个升序数组在某个点被翻转过，判断target在数组中的位置，若不存在返回-1,链表中可能含重复的数

        //方法一：暴力求解，直接遍历，时间复杂度为o(n)

        //如果可能有重复，那我们上一题判断左右部分是否有序的方法就失效了，因为可能有这种13111情况，虽然起点小于等于中间，但不代表右边就不是有序的，因为中点也小于等于终点，所有右边也是有序的。所以，如果遇到这种中点和两边相同的情况，我们两边都要搜索。
        int start = 0, end = nums.length - 1, mid = -1;

        while(start <= end){
            mid = (start + end) /2;
            if(target == nums[mid])
                return true;

            if(nums[mid] < nums[end] || nums[mid] < nums[start]){       //如果明确右边有序或者左边无序，可以直接在右边查找
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else
                    end = mid -1;
            }else if(nums[start] < nums[mid] || nums[mid] > nums[end]){  //如果明确左边有序或者右边无序，可以直接在左边查找
                if(target < nums[mid] && target >=nums[start]){
                    end = mid -1;
                }else
                    start = mid +1;
            }else{      //出现num[start]==nums[mid]==nums[end],直接向前移动一个，这样可以达到删除重复数。
                end--;
            }
        }
        return false;
    }
}
