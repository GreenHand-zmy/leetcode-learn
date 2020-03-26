package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 */
public class No1281SubtractProductAndSumOfDigits {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;

            product *= digit;
            sum += digit;

            n /= 10;
        }

        return product - sum;
    }

    /**
     * 示例 1：
     * <p>
     * 输入：n = 234
     * 输出：15
     * 解释：
     * 各位数之积 = 2 * 3 * 4 = 24
     * 各位数之和 = 2 + 3 + 4 = 9
     * 结果 = 24 - 9 = 15
     */
    @Test
    public void testCase1() {
        int result = subtractProductAndSum(234);
        Assert.assertEquals(15, result);
    }

    /**
     * 示例 2：
     * <p>
     * 输入：n = 4421
     * 输出：21
     * 解释：
     * 各位数之积 = 4 * 4 * 2 * 1 = 32
     * 各位数之和 = 4 + 4 + 2 + 1 = 11
     * 结果 = 32 - 11 = 21
     */
    @Test
    public void testCase2() {
        int result = subtractProductAndSum(4421);
        Assert.assertEquals(21, result);
    }
}
