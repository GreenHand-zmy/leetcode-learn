import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 * <p>
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 * <p>
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 */
public class No5356LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int target = matrix[row][column];

                if (isLuckyNumber(matrix, target, row, column)) {
                    result.add(target);
                    break;
                }

            }
        }
        return result;
    }

    private boolean isLuckyNumber(int[][] matrix, int num, int row, int column) {
        int[] targetRow = matrix[row];
        for (int targetNum : targetRow) {
            if (targetNum < num) {
                return false;
            }
        }

        for (int[] ints : matrix) {
            int targetNum = ints[column];
            if (targetNum > num) {
                return false;
            }
        }

        return true;
    }

    /**
     * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * Output: [15]
     * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
     */
    @Test
    public void testCase1() {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        List<Integer> luckyNumbers = luckyNumbers(matrix);
        System.out.println(luckyNumbers);
    }
    
    /**
     * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
     * Output: [12]
     * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
     */
    @Test
    public void testCase2() {
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> luckyNumbers = luckyNumbers(matrix);
        System.out.println(luckyNumbers);
    }

    /**
     * Example 3:
     * Input: matrix = [[7,8],[1,2]]
     * Output: [7]
     */
    @Test
    public void testCase3() {
        int[][] matrix = {{7,8},{1,2}};
        List<Integer> luckyNumbers = luckyNumbers(matrix);
        System.out.println(luckyNumbers);
    }
}
