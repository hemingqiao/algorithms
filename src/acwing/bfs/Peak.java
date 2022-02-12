package src.acwing.bfs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/15 22:12:10
 * description:
 * eg:
 * 5
 * 8 8 8 7 7
 * 7 7 8 8 7
 * 7 7 7 7 7
 * 7 8 8 7 8
 * 7 8 8 8 8
 *
 * 输出：2 1
 */
public class Peak {
    public static int N = 1010;
    public static int n;
    public static Queue<Pair> q = new ArrayDeque<>();
    public static int[][] h = new int[N][N];
    public static boolean[][] st = new boolean[N][N];

    public static void main(String[] args) throws IOException {
        // 比Scanner读的快一倍左右
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] temp = in.readLine().split(" ");
            for (int j = 0; j < n; j++) h[i][j] = Integer.parseInt(temp[j]);
        }
        int peak = 0, valley = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j]) {
                    Record r = bfs(i, j);
                    if (!r.first) ++peak;
                    if (!r.second) ++valley;
                }
            }
        }
        System.out.println(peak + " " + valley);
    }

    public static Record bfs(int sx, int sy) {
        q.offer(new Pair(sx, sy));
        st[sx][sy] = true;
        Record ret = new Record(false, false);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = p.x - 1; i <= p.x + 1; i++) {
                for (int j = p.y - 1; j <= p.y + 1; j++) {
                    // 不论四周是否被访问过，由于需要判断是否存在高于或者低于的点，所以都需要访问来判断
                    // 只有在计算连通块的时候，才需要判断是否访问过
                    if (i >= 0 && i < n && j >= 0 && j < n) {
                        if (h[i][j] != h[p.x][p.y]) {
                            if (h[i][j] > h[p.x][p.y]) ret.first = true;
                            else ret.second = true;
                        } else if (!st[i][j]) {
                            q.offer(new Pair(i, j));
                            st[i][j] = true;
                        }
                    }
                }
            }
        }
        return ret;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Record {
        boolean first; // 标记周围是否有高于此点的点
        boolean second; // 标记周围是否有低于此点的点

        public Record(boolean first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }
}
