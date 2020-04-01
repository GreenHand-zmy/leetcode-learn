package graph;

import annotation.Confused;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
@Confused
public class No1162AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        // 使用多源bfs遍历,将船的节点加入队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 单条船的单步可遍历的访问为上下左右
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int width = grid.length;
        int height = grid[0].length;
        int[] point = null;
        boolean hasOcean = false;
        // 队列不为空则一直遍历
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];

            // 进行上下左右遍历
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 判断是否超出边界,并且下一步是否海洋
                if (newX < 0 || newX >= width || newY < 0 || newY >= height || grid[newX][newY] != 0) {
                    continue;
                }
                hasOcean = true;
                grid[newX][newY] = grid[x][y] + 1;
                // 将遍历过的海洋加入队列
                queue.offer(new int[]{newX, newY});
            }
        }

        // 没有陆地或海洋
        if (!hasOcean) {
            return -1;
        }

        return grid[point[0]][point[1]] - 1;
    }

    /**
     * 输入：[[1,0,1],[0,0,0],[1,0,1]]
     * 输出：2
     * 解释：
     * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
     */
    @Test
    public void testCase1() {
        int result = maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}});
        Assert.assertEquals(2, result);
    }

    /**
     * 输入：[[1,0,0],[0,0,0],[0,0,0]]
     * 输出：4
     * 解释：
     * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
     */
    @Test
    public void testCase2() {
        int result = maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        Assert.assertEquals(4, result);
    }


}
