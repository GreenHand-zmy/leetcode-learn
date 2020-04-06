package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * （注：第 h 层可能包含 1~ 2h 个节点。）
 */
public class No958CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        // 循环直到遍历空节点时
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }

        // 排除队列头部空节点之后队列大小是否大于1
        while (!bfs.isEmpty() && bfs.peek() == null){
            bfs.poll();
        }

        return bfs.isEmpty();
    }

    @Test
    public void testCase1(){
        TreeNode tree = TreeNode.of("[1,2,3,4,5,6]");
        Assert.assertTrue(isCompleteTree(tree));
    }

    @Test
    public void testCase2(){
        TreeNode tree = TreeNode.of("[1,2,3,4,5,null,7]");
        Assert.assertFalse(isCompleteTree(tree));
    }
}
