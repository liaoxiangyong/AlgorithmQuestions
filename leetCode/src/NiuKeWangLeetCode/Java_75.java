package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/12/21.
 */
public class Java_75 {
    public boolean searchMatrix(int[][] matrix, int target) {       //在一个矩阵中判断是否存在target，矩阵每行升序，下一行的开始大于上一行的结束。
        //将matrix映射为一个一维数组，然后使用二分查找
        int row = matrix.length;
        if(row==0) return false;
        int col = matrix[0].length;
        if(col==0) return false;
        int start =0,end = row * col-1;
        while(start <= end){
            int mid = (start + end)/2;
            int rowIndex = mid/col;
            int colIndex = mid%col;
            if(matrix[rowIndex][colIndex]==target)
                return true;
            else if(matrix[rowIndex][colIndex]>target){
                end = mid-1;
            }else if(matrix[rowIndex][colIndex]<target){
                start = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Java_75 a = new Java_75();
        int[][] matrix = {{1}};
        a.searchMatrix(matrix,2);
    }
}
