package tree;

import annotation.Uncomplete;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
@Uncomplete
public class No257BinaryTreePaths {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        help(root, "");
        return result;
    }

    private void help(TreeNode root, String curPath) {
        StringBuilder sb = new StringBuilder(curPath);
        if (root == null) {
            result.add(sb.toString());
            return;
        }
        sb.append(root.val);
        if (root.left != null){
            help(root.left, sb.toString());
        }
        if (root.right != null){
            help(root.right, sb.toString());
        }

    }

    /**
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */
    @Test
    public void testCase1(){
        TreeNode root = TreeNode.of("[1,2,3,null,5]");
        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
    }
}
