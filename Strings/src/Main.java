import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            return;
        }
        int[][] values = new int[n][];
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            values[i] = new int[number];
            for (int j = 0; j < number; j++) {
                values[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(values[i]);
            int[] group = values[i];
            int sum = 0;
            for (int k = 0; k < group.length / 2; k++) {
                sum += group[k];
            }
            //todo
        }
    }
}

