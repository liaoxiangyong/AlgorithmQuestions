package SwordToOffer;

import java.util.ArrayList;

/**
 * Created by LXY on 2017/9/19.
 */
public class PrintMatrix_19 {

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int row = matrix.length;
        if(row==0) return list;
        int col = matrix[0].length;

        int maxRow = row-1;//行最大坐标
        int maxCol =col-1;//列最大坐标
        int minRow = 0;
        int minCol = 0;

        while((minRow<=maxRow)&&(minCol<=maxCol)){        //行和列大于0，就还可以继续遍历咯
            //上面行，做完之后minRow+1
            for(int i=minCol;i<=maxCol&&isRight( maxRow, minRow, maxCol, minCol, row, col);i++){
                list.add(matrix[minRow][i]);
            }
            minRow++;

            //右边列
            for(int i=minRow;i<=maxRow&&isRight( maxRow, minRow, maxCol, minCol, row, col);i++){
                list.add(matrix[i][maxCol]);
            }
            maxCol--;

            //下边行
            for(int i=maxCol;i>=minCol&&isRight( maxRow, minRow, maxCol, minCol, row, col);i--){
                list.add(matrix[maxRow][i]);
            }
            maxRow--;

            //左边列
            for(int i=maxRow;i>=minRow&&isRight( maxRow, minRow, maxCol, minCol, row, col);i--){
                list.add(matrix[i][minCol]);
            }
            minCol++;
        }
        return list;
    }

    public boolean isRight(int maxRow,int minRow,int maxCol,int minCol,int row,int col){       //判断范围
        return (minCol<=maxCol)&&(minRow<=maxRow)&&
                (maxCol<col&&maxCol>=0)&&
                (maxRow<row&&maxRow>=0)&&
                (minCol<col&&minCol>=0)&&
                (minRow<row&&minRow>=0);
    }

    public static void main(String[] args){
        int [][] matrix = {{1},{2},{3},{4},{5}};
        PrintMatrix_19 p = new PrintMatrix_19();
        ArrayList<Integer> list= p.printMatrix(matrix);
        System.out.println();
    }
}
