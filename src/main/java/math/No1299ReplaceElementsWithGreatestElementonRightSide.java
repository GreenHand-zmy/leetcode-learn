package math;

import javafx.geometry.VPos;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 *
 */
public class No1299ReplaceElementsWithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = findMax(arr, i + 1);
            arr[i] = max;
        }
        return arr;
    }

    private int findMax(int[] arr,int index){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        if (index > n-1){
            return -1;
        }
        for (int i = index; i < n; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 示例：
     *
     * 输入：arr = [17,18,5,4,6,1]
     * 输出：[18,6,6,6,1,-1]
     */
    @Test
    public void testCase1(){
        int[] result = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println(Arrays.toString(result));
    }
}
