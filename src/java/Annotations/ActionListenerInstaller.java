package java.Annotations;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {
    public static void processAnnotations(Object obj){
        try{
            Class<?> cl = obj.getClass();
            for(Method m: cl.getDeclaredMethods()){
                ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
                PrinlnAnno b = m.getAnnotation(PrinlnAnno.class);
                if(a != null)
                {
                    Field f = cl.getDeclaredField(a.source());
                    f.setAccessible(true);
                    addListener(f.get(obj),obj,m);
                }
                if(b != null)
                {
                    Field g = cl.getDeclaredField(b.print());
                    g.setAccessible(true);
                    addListener(g.get(obj),obj,m);
                }
            }
        }catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
    }
    public static void addListener(Object source, final Object param, final Method m) throws ReflectiveOperationException{
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };
        Object listener = Proxy.newProxyInstance(null,new Class[]{
                ActionListener.class },handler);
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        adder.invoke(source,listener);
    }
}
