package FIrstWeekProblems;

import java.util.HashMap;

public class twoSums {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,7,11,15};
        System.out.println(twoSum(test,9));
    }
}
