import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class No1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        return twoSum2(nums, target);
    }

    private int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];

            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }

                if (nums[j] == delta) {
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }
        throw new RuntimeException("No result");
    }

    private int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> container = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            container.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];

            Integer index = container.get(delta);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        throw new RuntimeException("No result");
    }

    @Test
    public void testCase1() {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    @Test
    public void testCase2() {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
