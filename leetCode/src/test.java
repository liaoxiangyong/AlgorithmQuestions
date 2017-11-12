import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/5/14.
 */
public class test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        System.out.println(list.contains(new Integer(1)));
    }
}
