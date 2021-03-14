public class DownKByMaxP {
    public static int[] getDownK(int[] array, int k) {
        if (k < 1 || k > array.length) {
            return array;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, i, array[i]);
        }
        for (int i = k; i != array.length; i++) {
            if (array[i] < kHeap[0]) {
                kHeap[0] = array[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void heapInsert(int[] array, int index, int value) {
        array[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (array[parent] < array[index]) {
                swap(array, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] array, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        while (left < size) {
            if (array[left] > array[largest]) {
                largest = left;
            }
            if (right < size && array[right] > array[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(array, largest, index);
            } else {
                break;
            }
            index = largest;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 1, 5, 6, 7, 2, 9};
        int[] minP = getDownK(array, 3);
        for (int i : minP) {
            System.out.println(i);
        }
    }
}
