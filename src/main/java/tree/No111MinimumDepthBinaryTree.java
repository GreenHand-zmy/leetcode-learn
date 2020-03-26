package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *
 */
public class No111MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return help(root, 1);
    }

    public int help(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        int leftDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = help(root.left, depth + 1);
        }
        int rightDepth = Integer.MAX_VALUE;
        if (root.right != null) {
            rightDepth = help(root.right, depth + 1);
        }

        return Math.min(leftDepth,rightDepth);
    }

    /**
     *示例:
     *
     *给定二叉树 [3,9,20,null,null,15,7],
     *
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15   7
     *返回它的最小深度  2.
     */
    @Test
    public void testCase1(){
        TreeNode data = TreeNode.of("[3,9,20,null,null,15,7]");
        int minDepth = minDepth(data);
        Assert.assertEquals(2,minDepth);
    }

    /**
     *示例:
     *
     *给定二叉树 [],
     *返回它的最小深度  0.
     */
    @Test
    public void testCase2(){
        TreeNode data = TreeNode.of("[]");
        int minDepth = minDepth(data);
        Assert.assertEquals(0,minDepth);
    }
    /**
     *示例:
     *
     *给定二叉树 [0],
     *返回它的最小深度  1.
     */
    @Test
    public void testCase3(){
        TreeNode data = TreeNode.of("[0]");
        int minDepth = minDepth(data);
        Assert.assertEquals(1,minDepth);
    }
}
