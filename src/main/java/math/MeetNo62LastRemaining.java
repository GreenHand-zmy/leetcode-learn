package math;

import annotation.Confused;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,2,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
@Confused
public class MeetNo62LastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remaining.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            remaining.remove(idx);
            n--;
        }
        return remaining.get(0);
    }

    /**
     * 示例 1：
     * <p>
     * 输入: n = 5, m = 3
     * 输出: 3
     */
    @Test
    public void testCase1() {
        int result = lastRemaining(5, 3);
        Assert.assertEquals(3, result);
    }

    /**
     * 示例 2：
     * <p>
     * 输入: n = 10, m = 17
     * 输出: 2
     */
    @Test
    public void testCase2() {
        int result = lastRemaining(10, 17);
        Assert.assertEquals(2, result);
    }
}
