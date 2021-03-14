/*
给定 一个 长度 不小于 2 的 数组 arr，
实现 一个 函数 调整 arr， 要么 让 所有 的 偶数 下标 都是 偶数，
要么 让 所有 的 奇数 下标 都是 奇数。
 */

public class oddEven {
    public static void oddEven(int[] array) {
        if (array.length < 2 || array == null) {
            return;
        }
        int even = 0;
        int odd = 1;
        int end = array.length - 1;
        while (even <= end && odd <= end) {
            if (array[end] % 2 != 0) {
                swap(array, odd, end);
                odd += 2;
            } else {
                swap(array, even, end);
                even += 2;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
