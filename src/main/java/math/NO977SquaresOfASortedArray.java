package math;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 */
public class NO977SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);
        return A;
    }

    /**
     * 示例 1：
     * <p>
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     */
    @Test
    public void testCase1() {
        int[] result = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 示例 2：
     * <p>
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    @Test
    public void testCase2() {
        int[] result = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(result));
    }


}
