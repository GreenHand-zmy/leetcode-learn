import annotation.Uncomplete;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 */
@Uncomplete
public class No118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        // 前两行是固定的
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 1){
            ArrayList<Integer> data = new ArrayList<>();
            data.add(1);
            result.add(data);
        }

        for (int i = 1; i <= numRows; i++) {


        }

        return result;
    }
    /**
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    @Test
    public void testCase1(){
        List<List<Integer>> list = generate(5);
        System.out.println(list);
    }
}
