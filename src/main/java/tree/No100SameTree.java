package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class No100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val.equals(q.val)) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    /**
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     * 输出: true
     */
    @Test
    public void testCase1(){
        TreeNode t1 = TreeNode.of("[1,2,3]");
        TreeNode t2 = TreeNode.of("[1,2,3]");
        Assert.assertTrue(isSameTree(t1, t2));
    }

    /**
     *
     * 示例 2:
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     * 输出: false
     */
    @Test
    public void testCase2(){
        TreeNode t1 = TreeNode.of("[1,2]");
        TreeNode t2 = TreeNode.of("[1,null,2]");
        Assert.assertFalse(isSameTree(t1, t2));
    }

    /**
     *
     * 示例 3:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * 输出: false
     */
    @Test
    public void testCase3(){
        TreeNode t1 = TreeNode.of("[1,2,1]");
        TreeNode t2 = TreeNode.of("[1,1,2]");
        Assert.assertFalse(isSameTree(t1, t2));
    }
}
