/**
给定 一个 数组 arr， 返回 子 数组 的 最大 累加 和。
 **/

public class maxSumOfSubArray {
    public static int maxSum(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}

