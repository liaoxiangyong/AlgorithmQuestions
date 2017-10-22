package NiuKeWangLeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LXY on 2017/10/19.
 */
public class Java_23 {

    //一个数组中最长的连续数的个数
    public int longestConsecutive(int[] nums) {

        //方法一：使用hashSet来查找，复杂度为2*O(n)
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);       //保持nums[i]中数的唯一性
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                int count = 1;
                set.remove(nums[i]);

                int low = nums[i]-1;
                while(set.contains(low)){
                    count++;
                    set.remove(low);
                    low--;
                }

                int high = nums[i]+1;
                while(set.contains(high)){
                    count++;
                    set.remove(high);
                    high++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
