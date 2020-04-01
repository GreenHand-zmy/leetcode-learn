import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class No945MinimumIncrementMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;

    }

    /**
     * 此方法会造成超时
     *
     * @param A
     * @return
     */
    private int minIncrementForUnique1(int[] A) {
        // 排序
        Arrays.sort(A);
        int times = 0;

        while (checkDup(A)) {

            for (int i = 0; i < A.length - 1; i++) {
                int gap = A[i + 1] - A[i];
                // 有重复
                if (gap == 0) {
                    A[i + 1] = A[i + 1] + 1;
                    times++;
                }
            }
            Arrays.sort(A);
        }

        return times;
    }

    private boolean checkDup(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 输入：[1,2,2]
     * 输出：1
     * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
     */
    @Test
    public void testCase1() {
        int result = minIncrementForUnique(new int[]{1, 2, 2});
        Assert.assertEquals(1, result);
    }

    /**
     * 输入：[3,2,1,2,1,7]
     * 输出：6
     * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
     * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
     */
    @Test
    public void testCase2() {
//        1 1 2 2 3 7;
        int result = minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7});
        Assert.assertEquals(6, result);
    }


    @Test
    public void testCase3() throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(No945MinimumIncrementMakeArrayUnique.
                        class.getResourceAsStream("No5356/testCase3.txt"))
        );
        int[] ints = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int result = minIncrementForUnique(ints);
        Assert.assertEquals(3905021, result);
    }
}
