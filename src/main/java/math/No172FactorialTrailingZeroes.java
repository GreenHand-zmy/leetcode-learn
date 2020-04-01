package math;

import annotation.Uncomplete;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
@Uncomplete
public class No172FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        BigInteger result = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        int temp = 0;
        String string = result.toString();
        for (int i = string.toCharArray().length - 1; i >= 0; i--) {
            if (string.charAt(i) == '0'){
                temp++;
            }else {
                break;
            }
        }
        return temp;
    }


    /**
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     */
    @Test
    public void testCase1() {
        int result = trailingZeroes(3);
        Assert.assertEquals(0, result);
    }

    /**
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     */
    @Test
    public void testCase2() {
        int result = trailingZeroes(5);
        Assert.assertEquals(1, result);
    }
    /**
     * 示例 3:
     * 输入: 6744
     * 输出: 1
     */
    @Test
    public void testCase3() {
        int result = trailingZeroes(6744);
        Assert.assertEquals(1682, result);
    }
}
