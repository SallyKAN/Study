public class noComparition {
    public int flip(int n) {
        return n ^ 1;
    }

    public int sign(int n) {
        return (n >> 31) ^ 1;
    }

    public int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return scA * a + scB * b;
    }
}
