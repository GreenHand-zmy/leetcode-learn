import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * 暴力 超时
     * O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 暴力遍历子序列
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = sum(nums, i, j);
                if (temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    private int sum(int [] nums,int start,int end){
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    @Test
    public void testCase1() {
        int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(data);
        Assert.assertEquals(6, result);
    }

    @Test
    public void testCase2() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(No945MinimumIncrementMakeArrayUnique.
                        class.getResourceAsStream("No53/testCase2.txt"))
        );
        int[] data = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int result = maxSubArray(data);
        Assert.assertEquals(11081, result);
    }
}
