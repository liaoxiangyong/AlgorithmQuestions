import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/5/14.
 */
public class Test {

    private  int stackLength = 1;

    public void stackLeek(){
        stackLength++;
        stackLeek();
    }


    public static void main(String[] args) {
        Test test = new Test();
        try{
            test.stackLeek();
        }catch (Throwable e){
            System.out.println("stack length:" + test.stackLength);
            throw e;
        }
    }
}
