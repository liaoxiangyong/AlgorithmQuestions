package SwordToOffer;

/**
 * Created by LXY on 2017/9/17.
 */
public class Search_1 {
    //判断二维数组中是否存在某个数，其中数组每行和每列都递增
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        if(row==0)
            return false;
        int col = array[0].length;
        if(col==0)
            return false;

        int i=row-1,j=0;
        while(i>=0&&j<col){
            if(array[i][j]>target){         //小于右下角的数，上移
                i--;
            }else if(array[i][j]<target){       //大于当前数，左移
                j++;
            }else
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Search_1 search_1 = new Search_1();
        System.out.println(search_1.Find(7,array));
    }
}
