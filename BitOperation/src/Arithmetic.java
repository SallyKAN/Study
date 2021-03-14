public class Arithmetic {
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int mutiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return res;
    }

    public static int divide(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; minus(i, 1)) {
            while ((x >> i) >= y) {
                res = res | 1 << i;
                x = minus(x, y << i);
            }
        }
        return isNeg(x)?negNum(a):a;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }
}
