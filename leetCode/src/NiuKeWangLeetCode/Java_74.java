package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/21.
 */
public class Java_74 {

    public void sortColors1(int[] nums) {            //一个包含0,1,2的数组，排序使所有0,1,2分别在一起。需要使用一步，且需要空间复杂度为o(1)
        //方法一：遍历数组计算0,1,2出现的次数，然后在nums中替换掉即可，这样使用了两个步骤
        int oneCount = 0,twoCount=0,zeroCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeroCount++;
            if(nums[i]==1) oneCount++;
            if(nums[i]==2) twoCount++;
        }
        for(int i=0;i<zeroCount;i++){
            nums[i] = 0;
        }
        for(int i=zeroCount;i<zeroCount+oneCount;i++){
            nums[i] = 1;
        }
        for(int i=zeroCount+oneCount;i<zeroCount+oneCount+twoCount;i++){
            nums[i] = 2;
        }
    }

    public void sortColors(int[] nums) {            //一个包含0,1,2的数组，排序使所有0,1,2分别在一起。需要使用一步，且需要空间复杂度为o(1)
        //双指针法，用一个start和一个end指向数组最前面元素和后面元素，遍历数组，若遇到0则和start交换，遇到2和end交换
        int start = 0;
        int end = nums.length-1;
        int i=0;
        while(i<=end){
            if(nums[i]==0){     //将0交换到前面
                int tmp=nums[i];
                nums[i]=nums[start];
                nums[start] =tmp;
                start++;
                i++;
            }
            else if(nums[i]==2){ //将2交换到后面
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            }
            else     //跳过
                i++;
        }
    }


    //方法三：平移插入
    public void sortColors2(int[] nums) {
        int i=-1,j=-1,k=-1;
        for(int x=0;x<nums.length;x++){
            if(nums[x]==0){
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            }else if(nums[x]==1){
                nums[++k] = 2;
                nums[++j] = 1;
            }else {
                nums[++k] = 2;
            }
        }
    }
        public static void main(String[] args) {
        Java_74 a = new Java_74();
        int[] nums = {0};
        a.sortColors(nums);
    }
}
