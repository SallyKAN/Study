public class HeapSort {
    public void max_heapify(int[] arr, int i) {
        int n = arr.length;
        int l = i >> 1;
        int r = i >> 1 + 1;
        int max = i;
        if (l < n && arr[l] > arr[i]) {
            max = l;
        } else if (r < n && arr[r] > arr[l]) {
            max = r;
        }
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            max_heapify(arr, max);
        }
    }

    public void build_heap(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            max_heapify(arr, i);
        }
    }

    public void heap_sort(int[] arr) {
        int n = arr.length;
        for (int i = n; i > 1; i--) {

        }
    }
}
