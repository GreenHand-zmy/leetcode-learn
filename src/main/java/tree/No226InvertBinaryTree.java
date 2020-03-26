package tree;

import org.junit.Test;

/**
 * 翻转一棵二叉树。
 *
 */
public class No226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.right==null && root.left == null)){
            return root;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left  = right;
        root.right = left;

        return root;
    }

    /**
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    @Test
    public void testCase1(){
        TreeNode result = TreeNode.of("[4,2,7,1,3,6,9]");
        TreeNode treeNode = invertTree(result);
        System.out.println(treeNode);
    }


}
