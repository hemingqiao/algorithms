package blogandquestion.algorithms.dfs.maxareaofisland695;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/05 18:27:00
 * description: 解题思路
 * see: https://leetcode-cn.com/problems/max-area-of-island/solution/biao-zhun-javadong-tai-gui-hua-jie-fa-100-by-mark-/
 */
public class ThirdSolution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 判断 base case
        // 如果坐标越界（小于0或者大于等于长度）或者坐标对应的值为0，直接返回0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0; // 沉岛，防止再次搜索到
        // 搜索四周
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i, j + 1);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i, j - 1);
        return num;
    }
}
