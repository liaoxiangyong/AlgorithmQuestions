import test.Person;
import test.chengxuyuan;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by LXY on 2018/3/3.
 */
public class Deglectproxy implements InvocationHandler {

    private Object targetObject;

    public Object getInstance(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("老子日你大爷");
        Object res = null;
        res = method.invoke(targetObject,args);
        return res;
    }

    public static void main(String[] args) {
        Person person = (Person) new Deglectproxy().getInstance(new chengxuyuan());
        System.out.println(person.ds("曹尼玛"));
    }
}
