package blogandquestion.algorithms.acwing.bfs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 20:56:56
 * description: 走迷宫问题
 * @see https://www.acwing.com/problem/content/description/846/
 */
public class Maze {
    public static int N = 110;
    public static int[][] g = new int[N][N]; // 记录迷宫的矩阵
    public static int[][] d = new int[N][N]; // d记录距离
    public static boolean[][] used = new boolean[N][N]; // used用来记录是否搜索过
    public static Queue<Pair> queue = new ArrayDeque<>();
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = in.nextInt();
            }
        }
        queue.offer(new Pair(0, 0));
        System.out.println(bfs(n, m));
    }

    public static int bfs(int n, int m) {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = p.x + dx[i], b = p.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] == 0 && !used[a][b]) {
                    d[a][b] = d[p.x][p.y] + 1;
                    queue.offer(new Pair(a, b));
                    used[a][b] = true;
                }
            }
        }
        return d[n - 1][m - 1];
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

class AnotherSolution {
    public static int N = 110;
    public static int[][] a = new int[N][N]; // a数组用来记录迷宫
    public static int[][] d = new int[N][N]; // d数组用来记录是否搜索过某个点和距离
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int aa = p.x + dx[i], bb = p.y + dy[i];
                // 迷宫中该位置需为0才能走，同时d数组中该位置为-1，表明是第一次搜索到
                if (aa >= 0 && aa < n && bb >= 0 && bb < m && a[aa][bb] == 0 && d[aa][bb] == -1) {
                    d[aa][bb] = d[p.x][p.y] + 1;
                    q.offer(new Pair(aa, bb));
                }
            }
        }
        System.out.println(d[n - 1][m - 1]);
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
