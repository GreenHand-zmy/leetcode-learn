package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 */
public class No1323Maximum69Number {

    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6'){
                sb.setCharAt(i,'9');
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }

    /**
     * 示例 1：
     *
     * 输入：num = 9669
     * 输出：9969
     * 解释：
     * 改变第一位数字可以得到 6669 。
     * 改变第二位数字可以得到 9969 。
     * 改变第三位数字可以得到 9699 。
     * 改变第四位数字可以得到 9666 。
     * 其中最大的数字是 9969 。
     */
    @Test
    public void testCase1(){
        int result = maximum69Number(9669);
        Assert.assertEquals(9969,result);
    }

    /**
     * 示例 2：
     *
     * 输入：num = 9996
     * 输出：9999
     * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
     *
     */
    @Test
    public void testCase2(){
        int result = maximum69Number(9996);
        Assert.assertEquals(9999,result);
    }

    /**
     * 示例 3：
     * 输入：num = 9999
     * 输出：9999
     * 解释：无需改变就已经是最大的数字了。
     */
    @Test
    public void testCase3(){
        int result = maximum69Number(9999);
        Assert.assertEquals(9999,result);
    }
}
