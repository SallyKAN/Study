

import com.sun.tools.javac.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-03-28
 */

public class ProxyHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*********代理方法执行前************");
        Object retObj = method.invoke(target, args);
        System.out.println("*********代理方法执行后************");
        return retObj;
    }
}
