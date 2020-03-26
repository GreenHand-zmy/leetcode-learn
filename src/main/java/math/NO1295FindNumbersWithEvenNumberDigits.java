package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class NO1295FindNumbersWithEvenNumberDigits {

    public int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            String numStr = String.valueOf(num);
            if (numStr.length() % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    /**
     * 示例 1：
     * <p>
     * 输入：nums = [12,345,2,6,7896]
     * 输出：2
     * 解释：
     * 12 是 2 位数字（位数为偶数） 
     * 345 是 3 位数字（位数为奇数）  
     * 2 是 1 位数字（位数为奇数） 
     * 6 是 1 位数字 位数为奇数） 
     * 7896 是 4 位数字（位数为偶数）  
     * 因此只有 12 和 7896 是位数为偶数的数字
     */
    @Test
    public void testCase1() {
        int result = findNumbers(new int[]{12, 345, 2, 6, 7896});
        Assert.assertEquals(2, result);
    }

    /**
     * 示例 2：
     * <p>
     * 输入：nums = [555,901,482,1771]
     * 输出：1
     * 解释：
     * 只有 1771 是位数为偶数的数字。
     */
    @Test
    public void testCase2() {
        int result = findNumbers(new int[]{555, 901, 482, 1771});
        Assert.assertEquals(1, result);
    }
}
