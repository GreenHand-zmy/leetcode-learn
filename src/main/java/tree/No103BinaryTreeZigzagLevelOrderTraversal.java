package tree;

import annotation.Uncomplete;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 */
@Uncomplete
public class No103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean normal = false;
        while (!queue.isEmpty()){
            List<TreeNode> row = new ArrayList<>();
            while (!queue.isEmpty()){
                row.add(queue.poll());
            }
            List<Integer> temp = row.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
            result.add(temp);
            normal = isNormal(queue, normal, row);

        }
        return result;
    }

    private boolean isNormal(Queue<TreeNode> queue, boolean normal, List<TreeNode> row) {
        for (TreeNode cur : row) {
            if (normal){
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }else {
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
            }
        }
        normal = !normal;
        return normal;
    }

    /**
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */
    @Test
    public void testCase1(){
        TreeNode root = TreeNode.of("[3,9,20,null,null,15,7]");
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }
}
