package tree;

import annotation.Confused;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
@Confused
public class NO538ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
    }


    /**
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     */
    @Test
    public void testCase1(){
        TreeNode result = convertBST(TreeNode.of("[5,2,13]"));
        TreeNode ans = TreeNode.of("[18,20,13]");

        Assert.assertTrue(TreeNode.equals(result, ans));
    }
}
