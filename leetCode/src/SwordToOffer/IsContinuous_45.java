package SwordToOffer;

import java.util.Arrays;

/**
 * Created by LXY on 2017/9/26.
 */
public class IsContinuous_45 {

    //LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。

    public boolean isContinuous(int [] numbers) {
        if(numbers.length<5) return false;

        Arrays.sort(numbers);       //排序从小到大
        int countZero = 0;      //需要零的个数
        int needZero = 0;       //计算需要的王的个数
        for(int i=0;i<numbers.length-1;i++){      //直接计算非0元素  的连续元素之间的差，然后看差值是否和零的个数相等；而且除了非0元素不能有重复元素
            if(numbers[i] == 0 ){
                countZero++;
            }else{
                if(numbers[i]==numbers[i+1]) return false;
                needZero += numbers[i+1]-numbers[i] -1;
            }
        }
        return countZero>=needZero;
    }

    public static void main(String[] args){
        IsContinuous_45 a = new IsContinuous_45();
        int[] nums = {3,6,5,0,0};
        System.out.println(a.isContinuous(nums));
    }
}
