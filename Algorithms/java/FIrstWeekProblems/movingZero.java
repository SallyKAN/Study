package FIrstWeekProblems;

import java.awt.font.FontRenderContext;

/*
    移动零
 */
public class movingZero {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
    }

}
