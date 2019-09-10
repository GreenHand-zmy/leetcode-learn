package tree;

import org.junit.Test;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class No965UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return false;
        }

        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if (root == null){
            return true;
        }

        return root.val == val && helper(root.left, val) && helper(root.right, val);
    }

    @Test
    public void testCase1(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);

        boolean univalTree = isUnivalTree(root);

    }

    @Test
    public void testCase2(){
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        boolean univalTree = isUnivalTree(root);

    }
}
