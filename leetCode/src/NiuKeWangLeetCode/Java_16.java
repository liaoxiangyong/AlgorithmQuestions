package NiuKeWangLeetCode;

import java.util.Arrays;

/**
 * Created by LXY on 2017/10/13.
 */
public class Java_16 {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;

        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i =1;i<ratings.length-1;i++){       //从左到右满足高的比低的多
            if(ratings[i]>ratings[i-1]){
                candy[i]  = candy[i-1] +1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){       //从右到左满足rating高的比低的多
            if(ratings[i+1]<ratings[i] && candy[i+1]>=candy[i]){        //若i+1的rating比i低，且糖果比他少
                candy[i] = candy[i+1]+1;
            }
        }

        int sum = 0;
        for(int i=0;i<candy.length;i++){
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Java_16 a = new Java_16();
        int[] b = {2,2};
        a.candy(b);
    }

}
