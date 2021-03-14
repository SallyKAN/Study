public class Singleton {
    public static final Singleton ex = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return ex;
    }
}
//public class Singleton {
//    private static final Singleton SINGLE_INSTANCE = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return SINGLE_INSTANCE;
//    }
//}