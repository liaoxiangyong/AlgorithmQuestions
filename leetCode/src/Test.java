import jdk.nashorn.internal.objects.NativeUint16Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXY on 2017/5/14.
 */
public class Test {

    public static Test SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finzlize方法开始执行了");
        Test.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new Test();

        //第一次对象拯救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("对象已死");


        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("对象已死");
    }
}
