package SwordToOffer;

/**
 * Created by LXY on 2017/10/1.
 */
public class HasPath_65 {

    //请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || str == null)
            return false;
        if(rows==0 || cols==0 || str.length==0) return false;
       for(int i = 0;i<rows;i++){
           for (int j=0;j<cols;j++){
               if(matrix[i*cols+j]==str[0]){            //开始判断
                    boolean[][] visited = new boolean[rows][cols];
                    boolean hasP = isPath(matrix,rows,cols,str,i,j,visited,0);
                    if(hasP) return true;
               }
           }
       }
        return false;
    }


    public boolean isPath(char[] matrix, int rows, int cols, char[] str,int i,int j,boolean[][] visited,int count){
        if(count == str.length-1){
            return true;
        }
        if(str[count] == matrix[i*cols+j]){
            visited[i][j] = true;       //标记为已遍历过
            count++;
        }
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        //向上
        if(i>0 && visited[i-1][j]==false && matrix[(i-1)*cols+j]==str[count]){
            up = isPath(matrix,rows,cols,str,i-1,j,visited,count);
        }

        //向下
        if(i<rows-1 && visited[i+1][j]==false && matrix[(i+1)*cols+j]==str[count]){
            down = isPath(matrix,rows,cols,str,i+1,j,visited,count);
        }

        //向左
        if(j>0 && visited[i][j-1]==false && matrix[i*cols+(j-1)]==str[count]){
            left = isPath(matrix,rows,cols,str,i,j-1,visited,count);
        }

        //向右
        if(j<cols-1 && visited[i][j+1]==false && matrix[i*cols+(j+1)]==str[count]){
            right = isPath(matrix,rows,cols,str,i,j+1,visited,count);
        }
        return up || down || left || right;
    }


    public static void main(String[] args) {
        HasPath_65 a = new HasPath_65();
        char[] matrix ={ 'a','b','c' ,'e' ,'s' ,'f' ,'c' ,'s' ,'a' ,'d' ,'e' ,'e'};
        char[] str = "abcb".toCharArray();
        System.out.println(a.hasPath(matrix,3,4,str));
    }
}
