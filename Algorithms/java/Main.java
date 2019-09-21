import java.util.Scanner;

public class exam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        while (sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            double out = a+b;
            System.out.println(out);
        }
    }
}
