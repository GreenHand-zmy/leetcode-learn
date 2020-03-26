package tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class NO04MinimumHeightTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[n / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, n / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, n / 2 + 1, n));
        return root;
    }

    /**
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *           0
     *          / \
     *        -3   9
     *        /   /
     *      -10  5
     */
    @Test
    public void testCase1(){
        TreeNode result = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
