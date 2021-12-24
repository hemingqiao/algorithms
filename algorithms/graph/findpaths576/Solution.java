package blogandquestion.algorithms.graph.findpaths576;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/15 09:07:21
 * description:
 */
public class Solution {
    // TLE
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    long res = 0;
    int m, n, time;
    long MOD = (long) (1e9 + 7);

    public int findPaths(int m, int n, int N, int i, int j) {
        this.m = m;
        this.n = n;
        time = N;
        dfs(i, j, 0);
        return (int) (res % MOD);
    }

    public void dfs(int sx, int sy, int t) {
        if (t >= time) return;
        for (int i = 0; i < 4; i++) {
            int x = sx + dx[i], y = sy + dy[i];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                ++res;
            }
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(x, y, t + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.findPaths(8, 7, 16, 1, 5);
        System.out.println(res);
    }
}
