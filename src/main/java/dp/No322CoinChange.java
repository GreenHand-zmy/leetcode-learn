package dp;

import annotation.Confused;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
@Confused
public class No322CoinChange {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub;
            sub = coinChange(coins, amount - coin);

            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);

        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    /**
     * 示例 1:
     * <p>
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     */
    @Test
    public void testCase1() {
        int result = coinChange(new int[]{1, 2, 5}, 11);
        Assert.assertEquals(3, result);
    }

    /**
     * 示例 2:
     * <p>
     * 输入: coins = [2], amount = 3
     * 输出: -1
     */
    @Test
    public void testCase2() {
        int result = coinChange(new int[]{2}, 3);
        Assert.assertEquals(-1, result);
    }
}
