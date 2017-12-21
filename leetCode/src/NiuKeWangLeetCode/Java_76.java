package NiuKeWangLeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by LXY on 2017/12/21.
 */
public class Java_76 {
    public void setZeroes1(int[][] matrix) {     //如果一个矩阵的元素为0，那么其所在行和所在列都设置为0,能不能使用空间复杂度为o(1)
        //方法一：遍历matrix，分别用两个集合记录需要变化的行和列，然后在遍历设置，空间复杂度为0(m+ns)
        int row = matrix.length;
        if(row==0) return;;
        int col = matrix[0].length;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        //行
        Iterator<Integer> iterator = rowSet.iterator();
        while(iterator.hasNext()){
            Integer res = iterator.next();
            for(int i=0;i<col;i++){
                matrix[res][i] = 0;
            }
        }

        iterator = colSet.iterator();
        while(iterator.hasNext()){
            Integer res = iterator.next();
            for(int i=0;i<row;i++){
                matrix[i][res] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) { //空间复杂度为o(1)
        //不使用额外空间的方法类似，就是把第一行和第一列作为标记。  首先  先判断第一行第一列是否含有0，并用两个bool变量记录起来。这样，遍历一遍之后就把所有的行和列都在第一行和第一列中体现出来。接下来就是，根据第一行和第一列的0元素，把其所在的行和列置0，不包括第一行和第一列。
        int row = matrix.length;
        if(row==0) return;;
        int col = matrix[0].length;
        boolean fr = false,fc = false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //根据第一行和第一列的0元素，把其所在的行和列置0，不包括第一行和第一列。
        for(int i=1;i<row;i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        //最后如果第一行有或者第一列原来就有为0的元素，置为0
        if(fr){
            for(int i=0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Java_76 a =  new Java_76();
        int[][] matrix = {{1,0,2}};
        a.setZeroes(matrix);
    }
}
