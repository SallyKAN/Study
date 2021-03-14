public class TopKByMinP {
    public static int[] getTopK(int[] array, int k) {
        if (k < 1 || k >= array.length) {
            return array;
        }
        int[] minP = new int[k];
        for (int i = 0; i != k; i++) {
            minPinsert(minP, i, array[i]);
        }

        for (int i = k; i != array.length; i++) {
            if (array[i] > minP[0]) {
                minP[0] = array[i];
                heapify(minP,0,k);
            }
        }
        return minP;
    }

    public static void minPinsert(int[] array, int index, int value) {
        array[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(array, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(int[] array, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int min = index;
        while (left < size) {
            if (array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != index) {
                swap(array, min, index);
            }else {
                break;
            }
            index = min;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 1, 5, 6, 7, 2, 9};
        int[] minP = getTopK(array, 3);
        for (int i : minP) {
            System.out.println(i);
        }
    }

}
