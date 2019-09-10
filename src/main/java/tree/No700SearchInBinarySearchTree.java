package tree;

import org.junit.Test;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class No700SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result;

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            result = searchBST(root.right, val);
        } else {
            result = searchBST(root.left, val);
        }

        return result;
    }

    /**
     * 给定二叉搜索树:
     * <p>
     * 4
     * / \
     * 2   7
     * / \
     * 1   3
     * <p>
     * 和值: 2
     */
    @Test
    public void testCase1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        TreeNode treeNode = searchBST(root, 5);

        System.out.println();
    }
}
