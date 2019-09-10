package tree;

import org.junit.Test;

/**
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * /   \
 * 2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 */
public class No563BinaryTreeTilt {
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = 0;
        int rightSum = 0;

        leftSum += helper(root.left);
        rightSum += helper(root.right);

        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }

    @Test
    public void testCase1() {
        TreeNode root = TreeNode.of("[1,2,3,4]");
        int tilt = findTilt(root);
        System.out.println(this.tilt);
    }

    @Test
    public void testCase2() {
        TreeNode root = TreeNode.of("[1,2,3]");
        int tilt = findTilt(root);
        System.out.println(this.tilt);
    }
}
