package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/11.
 */
public class Java_61 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1,j=n-1;
        while(i>=0&&j>=0){
            if(nums1[i]<nums2[j]){
                nums1[k] = nums2[j];
                j--;
            }else{
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        while(i>=0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
