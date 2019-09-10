package tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 */
public class No783MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        return minDiffInBST1(root);
    }

    private int minDiffInBST1(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();

        helper(root, nodes);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size() - 1; i++) {
            int diff = Math.abs(nodes.get(i + 1) - nodes.get(i));
            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }

    private void helper(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        helper(root.left, nodes);

        nodes.add(root.val);

        helper(root.right, nodes);
    }

    @Test
    public void testCase1() {
        TreeNode root = TreeNode.of("[4,2,6,1,3,null,null]");
        int diff = minDiffInBST(root);
    }
}
