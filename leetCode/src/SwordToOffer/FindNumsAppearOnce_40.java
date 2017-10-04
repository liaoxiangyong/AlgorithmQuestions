package SwordToOffer;

/**
 * Created by LXY on 2017/9/25.
 */
public class FindNumsAppearOnce_40 {
    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //方法一：遍历数组，用一个hashMap保存出现的次数
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0;i < array.length;i++){
//            if(map.containsKey(array[i])){
//                map.put(array[i],2);
//            }else{
//                map.put(array[i],1);
//            }
//        }
//        int[] result =new int[2];
//        int count = 0;
//        Iterator iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry) iterator.next();
//            if((int)entry.getValue()==1)
//                result[count++] = (int)entry.getKey();
//        }
//        num1[0] = result[0];
//        num2[0] = result[1];

        //方法二，排序然后查找（当前数和前一个和后一个数都不一样），空间复杂度降低，略




//        int[] temp = new int[32];     //其他数出现奇数次（>1），一个数出现一次
//        int len = array.length;
//        int res = 0;
//        for(int i=0;i<len;i++){
//            for(int j=0;j<32;j++){
//                if((array[i]>>j&1)==1){     //第j为数为1的话加1
//                    temp[j] +=1;
//                }
//            }
//        }

        //方法三，利用异或操作
        int sum = 0;        //记录所有值异或操作后的值，其实就是两个不同数的异或结果
        for(int i =0;i<array.length;i++){
            sum ^= array[i];
        }
        sum &= -sum;    //取得sum最右边一个为1位置，用这个1就可以得出两个不同的数，因为要为1，肯定两个在该位置不同
        for(int i=0;i<array.length;i++){
            if((sum&array[i])==0){      //可以得到两个不同的数与sum去&得到的结果一定不同，所以可以分开
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args){
        FindNumsAppearOnce_40 a = new FindNumsAppearOnce_40();
        int num1[] =new int[1];
        int num2[] = new int[1];
        int[] arr = {2,4,3,6,3,2,5,5};
        a.FindNumsAppearOnce(arr,num1,num2);
    }
}
