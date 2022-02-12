package src.dfs.maxareaofisland695;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/05 17:20:18
 * description:
 */
public class AnotherSolution {
    // 方便获取四个方向上的左边：(-1,0)，(0,1)，(1,0)，(0,-1)
    int[] directions = new int[]{-1, 0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    // dfs函数是以row、column为中心，从grid中获取该左边四周的面积
    private int dfs(int[][] grid, int row, int column) {
        if (grid[row][column] == 0) return 0;
        int local_area = 1;
        grid[row][column] = 0; // 沉岛，防止再次搜索到
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = row + directions[i];
            y = column + directions[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > 0) {
                local_area += dfs(grid, x, y);
            }
        }
        return local_area;
    }
}
