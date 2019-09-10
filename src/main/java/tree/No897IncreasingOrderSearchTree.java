package tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，
 * 并且每个结点没有左子结点，只有一个右子结点。
 */
public class No897IncreasingOrderSearchTree {


    public TreeNode increasingBST(TreeNode root) {
        return increasingBST2(root);
    }



    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        helper(root, nodes);

        TreeNode result = new TreeNode(nodes.get(0)), temp = result;

        for (int i = 1; i < nodes.size(); i++) {
            temp.right = new TreeNode(nodes.get(i));
            temp = temp.right;
        }
        return result;
    }

    private void helper(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        helper(root.left,nodes);

        nodes.add(root.val);

        helper(root.right,nodes);
    }

    private TreeNode dummyNode =  new TreeNode(-1);
    private TreeNode currentNode =  dummyNode;

    public TreeNode increasingBST2(TreeNode root) {
        helper(root);
        return dummyNode.right;
    }

    public void helper(TreeNode root) {
        if (root == null){
            return;
        }

        helper(root.left);
        currentNode.right = new TreeNode(root.val);
        currentNode = currentNode.right;
        helper(root.right);
    }
    /**
     * [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 5
     * / \
     * 3    6
     * / \    \
     * 2   4    8
     * /        / \
     * 1        7   9
     */
    @Test
    public void testCase1() {

        TreeNode treeNode1 = TreeNode.of("[5,3,6,2,4,null,8,1,null,null,null,7,9]");
        System.out.println(treeNode1);

        TreeNode treeNode = increasingBST(treeNode1);
        System.out.println(treeNode);
    }
}
