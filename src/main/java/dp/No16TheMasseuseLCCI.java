package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 注意：本题相对原题稍作改动
 */
public class No16TheMasseuseLCCI {
    public int massage(int[] nums) {
        int n = nums.length;
        // 边界
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 设置状态转移方程 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    /**
     * 示例 1：
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     */
    @Test
    public void testCase1() {
        int result = massage(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, result);
    }

    /**
     * 示例 2：
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     */
    @Test
    public void testCase2() {
        int result = massage(new int[]{2, 7, 9, 3, 1});
        Assert.assertEquals(12, result);
    }

    /**
     * 示例 3：
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     */
    @Test
    public void testCase3() {
        int result = massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3});
        Assert.assertEquals(12, result);
    }
}
