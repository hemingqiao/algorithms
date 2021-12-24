package blogandquestion.algorithms.graph.swiminwater778;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 10:08:04
 * description:
 * 参考：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-y-862o/
 */
public class AnotherSolution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            boolean[][] visited = new boolean[n][n];
            if (grid[0][0] <= mid && dfs(grid, 0, 0, mid, visited, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean dfs(int[][] grid, int x, int y, int threshold, boolean[][] visited, int n) {
        // 这里不要忘记判断grid[x][y] <= threshold
        if (x == n - 1 && y == n - 1 && grid[x][y] <= threshold) {
            return true;
        }
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > threshold) return false;
        visited[x][y] = true;
        boolean res = false;
        res = dfs(grid, x - 1, y, threshold, visited, n)
                || dfs(grid, x, y + 1, threshold, visited, n)
                || dfs(grid, x + 1, y, threshold, visited, n)
                || dfs(grid, x, y - 1, threshold, visited, n);
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 2}, {1, 3}};
        AnotherSolution as = new AnotherSolution();
        int res = as.swimInWater(test);
        System.out.println(res);
    }
}
