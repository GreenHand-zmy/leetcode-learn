package tree;

import org.junit.Test;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 */
public class No938RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;

        if (root == null) {
            return sum;
        }

        if (root.val <= R && root.val >= L) {
            sum += root.val;
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);

        } else if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else {
            sum += rangeSumBST(root.left, L, R);
        }

        return sum;
    }


    /**
     * 示例 1：
     * <p>
     * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
     * 输出：32
     */
    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }
}
