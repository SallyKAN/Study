
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int max = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j != 0) {
                    max = i * j - 1;
                } else {
                    max = Math.max(max, (getMinMultiple(i, j) - getMaxDivisor(i, j)));
                }
            }

        }
        System.out.println(max);
    }

    public static int getMaxDivisor(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (max % min == 0) {
            return min;
        }
        return getMaxDivisor(min, max % min);
    }

    public static int getMinMultiple(int a, int b) {

        return a * b / getMaxDivisor(a, b);
    }
}