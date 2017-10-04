package SwordToOffer;

/**
 * Created by LXY on 2017/9/25.
 */
public class GetNumberOfK_37 {
    //统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int [] array , int k) {

        //先用二分查找找到一个为k的值，然后分别向前和向后查找，时间复杂度为o(logn)吧
        int count = 0;      //记录出现的次数
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid]==k){
                //向前查找
                int pre = mid-1;
                while(pre>=0&&array[pre]==k){
                    count++;
                    pre--;
                }
                //向后查找
                int next = mid + 1;
                while(next<array.length&&array[next]==k){
                    count++;
                    next++;
                }
                count++;
                break;
            }else if(array[mid]>k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        GetNumberOfK_37 a = new GetNumberOfK_37();
        int[] b = {2,3,5,6,8,9,9,9};
        System.out.println(a.GetNumberOfK(b,2));
    }
}
