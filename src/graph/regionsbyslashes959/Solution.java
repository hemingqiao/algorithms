package src.graph.regionsbyslashes959;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/25 12:49:15
 * description:
 *
 * 参考：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/mei-ge-xiao-ge-fen-jie-wei-3-3-fang-ge-qiu-lian-to/129854
 */
public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] nums = new boolean[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    nums[i * 3][j * 3 + 2] = true;
                    nums[i * 3 + 1][j * 3 + 1] = true;
                    nums[i * 3 + 2][j * 3] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    nums[i * 3][j * 3] = true;
                    nums[i * 3 + 1][j * 3 + 1] = true;
                    nums[i * 3 + 2][j * 3 + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (!nums[i][j]) {
                    res++;
                    dfs(nums, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] nums, int i, int j) {
        int n = nums.length;
        if (i >= 0 && i < n && j >= 0 && j < n && !nums[i][j]) {
            nums[i][j] = true;
            dfs(nums, i - 1, j);
            dfs(nums, i, j + 1);
            dfs(nums, i + 1, j);
            dfs(nums, i, j - 1);
        }
    }
}
