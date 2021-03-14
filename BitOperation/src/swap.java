public class swap {
    public static void main(String[] args) {
        int a = 12;
        int b = 21;
        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
