import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.EnumMap;

public class PositionTest {
    public static void main(String[] args) {
        Class<Position> enumClass = Position.class;
        String modifiers = Modifier.toString(enumClass.getModifiers());
        System.out.println("enum 修饰符：" + modifiers);
        System.out.println("enum 类型的父类：" + enumClass.getSuperclass());
        System.out.println("enum 自定义方法：");
        Method[] methods = enumClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
