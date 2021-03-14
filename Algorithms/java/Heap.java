public class Heap {
    int[] b;
    private int size;



    private static void swim(int[] a, int i) {
        while (i >= 0 && (a[i / 2] < a[i])) {
            int temp = a[i / 2];
            a[i / 2] = a[i];
            a[i] = temp;
            i = i / 2;
        }
    }

    public static void insert(int[] a, int n, int i) {
        a[n] = i;
        swim(a, n);
//        setSize()
//        n++;
    }

    public static int delMax(int[] a) {
        int max = a[0];
        exch(a, max, a.length - 1);
        sink(a, 0);
        return max;
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sink(int[] a, int i) {
        int len = a.length;
        while (2 * i <= len) {
            int j = 2 * i;
            if (j < len && (a[j - 1] < a[j])) j++;
            if (!(a[i] <= a[j])) break;
            exch(a, i, j);
            i = j;
        }
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{80, 82, 73, 79, 42, 82, 42, 42, 73, 42, 84, 42, 89, 42, 42, 42, 81, 85, 69, 42, 42, 42, 85, 42, 69};
//        int[] a = new int[]{2, 3, 6, 1, 8, 7, 9, 0};
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 42) {
                delMax(b);
            } else {
                insert(b, i, a[i]);
            }
        }
        printArray(b);
//        String s= "PRIO*R**I*T*Y***QUE***U*E";
//        char[] chars = s.toCharArray();
//        for (char c:chars){
//            System.out.print(Integer.valueOf(c)+",");
//        }
    }

//    public static int getSize() {
//        return size;
//    }

    public void setSize(int size) {
        this.size = size;
    }
}
