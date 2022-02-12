package src.acwing.bfs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/15 21:25:17
 * description:
 */
public class Castle {
    public static int N = 55;
    public static Queue<Pair> q = new ArrayDeque<>();
    public static int n, m;
    public static int[][] g = new int[N][N]; // g用来记录每个点的值
    public static boolean[][] st = new boolean[N][N]; // 记录是否遍历过某个位置
    public static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0}; // 遍历方向 左 -> 上 -> 右 -> 下

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) g[i][j] = in.nextInt();
        }
        int area = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!st[i][j]) {
                    area = Math.max(area, bfs(i, j));
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(area);
    }

    public static int bfs(int sx, int sy) {
        int area = 0;
        q.offer(new Pair(sx, sy));
        st[sx][sy] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            ++area;
            for (int i = 0; i < 4; i++) {
                if ((g[p.x][p.y] >> i & 1) == 1) continue;
                int a = p.x + dx[i], b = p.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b]) {
                    q.offer(new Pair(a, b));
                    st[a][b] = true;
                }
            }
        }
        return area;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
