package FIrstWeekProblems;

import sun.awt.Symbol;

public class merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < m || j < n) {
            if (i == m) {
                res[k++] = nums2[j++];
            } else if (j == n) {
                res[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l] = res[l];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }
}
