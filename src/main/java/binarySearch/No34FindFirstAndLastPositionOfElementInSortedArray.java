package binarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class No34FindFirstAndLastPositionOfElementInSortedArray {

    private int leftBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (target == num) {
                right = mid - 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    private int rightBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (target == num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 检查出界情况
        if (right < 0 || nums[right] != target){
            return -1;
        }

        return right;
    }

    private int binarySearch1(int[] nums, int target, boolean rightFlag) {
        int left = 0, right = nums.length - 1;
        int endMid = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];

            if (target < num) {
                right = mid - 1;
            } else if (target > num) {
                left = mid + 1;
            } else {
                endMid = mid;
                break;
            }
        }

        // 二分法找到中间点之后,进行前移或者后移,因为找到的中间点不一定就是正确答案
        if (endMid < 0) {
            return -1;
        }

        if (rightFlag) {
            while (nums[endMid] == target && endMid < nums.length - 1 && nums[endMid + 1] == target) {
                endMid++;
            }
        } else {
            while (nums[endMid] == target && endMid > 0 && nums[endMid - 1] == target) {
                endMid--;
            }
        }


        return endMid;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = leftBinarySearch(nums, target);
        result[1] = rightBinarySearch(nums, target);
        return result;
    }

    /**
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     */
    @Test
    public void testCase1() {
        int[] data = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(data, 8);

        Assert.assertArrayEquals(new int[]{3, 4}, ints);
    }

    /**
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    @Test
    public void testCase2() {
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assert.assertArrayEquals(new int[]{-1, -1}, ints);
    }

    @Test
    public void testCase3() {
        int[] ints = searchRange(new int[]{1}, 1);
        Assert.assertArrayEquals(new int[]{0, 0}, ints);
    }

    @Test
    public void testCase4() {
        int[] ints = searchRange(new int[]{}, 0);
        Assert.assertArrayEquals(new int[]{-1, -1}, ints);
    }
}
