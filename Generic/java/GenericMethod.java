public class GenericMethod {
    public <A, B, C> void f(String s, A a, B b, C c) {
        System.out.println(s.getClass().getName() + "\n" + a.getClass().getName() + "\n" + b.getClass().getName() + "\n" + c.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        method.f("j", "hello", 1, 'c');
    }
}
