package SwordToOffer;

/**
 * Created by LXY on 2017/9/28.
 */
public class Duplicate_50 {

    //在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
//        if (numbers.length ==0 || numbers == null){
//            return false;
//        }
//        if(numbers.length != length) return false;
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        for(int i=0;i<numbers.length;i++){
//            if(numbers[i]>length-1) return false;
//            if(hashMap.containsKey(numbers[i])){
//                int count = hashMap.get(numbers[i]);
//                hashMap.remove(numbers[i]);
//                hashMap.put(numbers[i],count+1);
//            }else{
//                hashMap.put(numbers[i],1);
//            }
//        }
//
//        Iterator iterator = hashMap.entrySet().iterator();
//
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry) iterator.next();
//            if((int)entry.getValue()>1){
//                duplication[0] = (int) entry.getKey();
//                return true;
//            }
//        }
//
//        return false;
//        if(numbers == null || numbers.length <=0)
//            return false;
//
//        boolean[] A = new boolean[length];
//        for(int num:numbers){
//            if(A[num]){
//                duplication[0] = num;
//                return true;
//            }else{
//                A[num] = true;
//            }
//        }
//        return false;
        for ( int i= 0 ; i<length; i++) {
            if(numbers[i]>length) return false;
        }
        for ( int i= 0 ; i<length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = numbers[index] - length;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false ;
    }

    public static void  main(String[] args){
        Duplicate_50 a = new Duplicate_50();
        int[] nums = {2,1,3,1,4};
        int length = 5;
        int[] dup = {-1};
        System.out.println(a.duplicate(nums,length,dup));
    }
}
