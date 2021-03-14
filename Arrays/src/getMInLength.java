public class getMInLength {
    public static int getMinLength(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int min = array[array.length - 1];
        int minIndex = -1;
        for (int i = array.length - 2; i > 0; i--) {
            if (array[i] > min) {
                minIndex = i;
            } else {
                min = Math.min(min, array[i]);
            }
        }

        if (minIndex == -1) {
            return 0;
        }
        int max = array[0];
        int maxIndex = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < max) {
                maxIndex = i;
            } else {
                max = Math.max(max, array[i]);
            }
        }
        System.out.println(maxIndex);
        System.out.println(minIndex);
        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 7, 6, 5, 4, 10, 11, 12, 14, 13};
        System.out.println(getMinLength(test));
    }
}
