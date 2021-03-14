import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class CountingSort {
    public static int[] sort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[256];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < 256; i++) {
            count[i] = count[i - 1] + count[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[--count[arr[i]]] = arr[i];
        }
        for (int k : output) {
            System.out.print(k + ",");
        }
        return output;
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }

    }

    public static void countSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] / exp) % 10]] = arr[i];
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
        for (int k : output) {
            System.out.print(k + ",");
        }
        System.out.println();
    }

    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        for (int k : arr) {
            System.out.print(k + ",");
        }
        System.out.println();
    }

    public static void insertSort2(int[] arr){
        int n = arr.length;
        for (int j=1;j<n;j++){
            int temp = arr[j];
            int i = j-1;
            while (i>0 && arr[i]>temp){
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = temp;
        }
        for (int k : arr) {
            System.out.print(k + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 5, 7, 6, 9, 120, 10, 78, 30};
//        radixSort(test);
         insertSort2(test);
//        int i = (123 / exp)
//        sort(test);
//        System.out.println(sort(test));
//        int i = 10;
//        for (int k = 0; k < 8; k++) {
//            System.out.println(--i);
//            System.out.println(i--);
//        }
    }

}
