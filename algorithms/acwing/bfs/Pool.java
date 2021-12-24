package blogandquestion.algorithms.acwing.bfs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/14 23:15:22
 * description:
 */
public class Pool {
    public static int N = 1010;
    public static int n, m;
    public static char[][] g = new char[N][N]; // 记录池塘中的每个点
    public static boolean[][] st = new boolean[N][N]; // 用来标记是否遍历过某个点
    public static Queue<Pair> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] cur = in.readLine().split(" ");

        n = Integer.parseInt(cur[0]);
        m = Integer.parseInt(cur[1]);

        for (int i = 0; i < n; i++) {
            char[] arr = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                g[i][j] = arr[j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'W' && !st[i][j]) {
                    bfs(i, j);
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }

    // start x, start y
    public static void bfs(int sx, int sy) {
        st[sx][sy] = true;
        queue.offer(new Pair(sx, sy));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = p.x - 1; i <= p.x + 1; i++) {
                for (int j = p.y - 1; j <= p.y + 1; j++) {
                    if (i == p.x && j == p.y) continue;
                    if (i >= 0 && i < n && j >= 0 && j < m && g[i][j] == 'W' && !st[i][j]) {
                        queue.offer(new Pair(i, j));
                        st[i][j] = true;
                    }
                }
            }
        }
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

class PoolAnotherSolution {
    public static int N = 1010;
    public static int n, m;
    public static char[][] g = new char[N][N]; // 记录池塘中的每个点
    public static Queue<Pair> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] cur = in.readLine().split(" ");

        n = Integer.parseInt(cur[0]);
        m = Integer.parseInt(cur[1]);

        for (int i = 0; i < n; i++) {
            char[] arr = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                g[i][j] = arr[j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'W') {
                    bfs(i, j);
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }

    // start x, start y
    public static void bfs(int sx, int sy) {
        g[sx][sy] = '.'; // 遍历过某个代表水域的点之后，可以将其改为'.'来标识已经访问过
        queue.offer(new Pair(sx, sy));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = p.x - 1; i <= p.x + 1; i++) {
                for (int j = p.y - 1; j <= p.y + 1; j++) {
                    if (i == p.x && j == p.y) continue;
                    if (i >= 0 && i < n && j >= 0 && j < m && g[i][j] == 'W') {
                        queue.offer(new Pair(i, j));
                        g[i][j] = '.';
                    }
                }
            }
        }
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
