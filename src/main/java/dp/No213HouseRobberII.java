package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class No213HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // dp(n - 1) = dp(n - 2)+nums[n-2]
        // dp(n -1) = dp(n -2)
        int help1 = help(Arrays.copyOfRange(nums, 1, n));
        int help2 = help(Arrays.copyOfRange(nums, 0, n - 1));

        return Math.max(help1, help2);

    }

    public int help(int[] nums) {
        int n = nums.length;
        // 边界
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // 设置状态转移方程 dp(n) = max(dp(n-1),dp(n-2)+nums[n])
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    /**
     * 示例 1:
     * <p>
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     */
    @Test
    public void testCase1() {
        int result = rob(new int[]{2, 3, 2});
        Assert.assertEquals(3, result);
    }

    /**
     * 示例 2:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     */
    @Test
    public void testCase2() {
        int result = rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, result);
    }
}
