public class Sort {

    public static void heapSort1(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(a, n, i);
        }
        while (n >= 1 ){
//        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[n-1];
            a[n-1] = temp;
            n--;
            sink(a, n, 0);
        }
    }

    public static void sink(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            sink(a, n, largest);
        }
    }


    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void heapSort2(int[] a) {
        int n = a.length;
        for (int i=n/2-1;i>=0;i--){
            sink2(a,n,i);
        }
        while (n>1){
            int temp = a[n-1];
            a[n-1] = a[0];
            a[0] = temp;
            sink2(a,n,0);
        }
    }

    public static void sink2(int[] a,int n, int i){
        while (2*i+2<a.length){
            int large = 2*i +2;
            if (large < n && (a[large-1] < a[large])) large++;
            if (!(a[i] <= a[large])) break;
            int temp = a[i];
            a[i] = a[large];
            a[large] = temp;
            i = large;
        }
    }


    public static void main(String[] args) {
        int[] s = new int[]{8, 1, 3, 4, 2, 5, 7, 6, 9, 0};
//        Sort sort = new Sort();
        heapSort2(s);
        printArray(s);
    }
}
