package NiuKeWangLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LXY on 2017/12/20.
 */
public class Java_71 {


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {        //给出一个不含重复数的集合，要求求出该集合的所有可能的集合
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(S);
        findResult(res,list,S,0);
        return res;
    }

    private void findResult(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int[] nums,int start){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            findResult(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Java_71 a = new Java_71();
        a.subsets(nums);
    }
}
