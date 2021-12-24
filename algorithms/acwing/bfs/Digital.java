package blogandquestion.algorithms.acwing.bfs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/30 20:51:43
 * description:
 */
public class Digital {
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(ss[i]);
        }
        System.out.println(bfs(sb.toString()));
    }

    public static int bfs(String start) {
        Deque<String> q = new ArrayDeque<>();
        Map<String, Integer> d = new HashMap<>();
        q.offer(start);
        d.put(start, 0);
        String end = "12345678x";
        while (!q.isEmpty()) {
            String tt = q.poll();
            if (tt.equals(end)) return d.get(tt);
            StringBuilder t = new StringBuilder(tt);
            int p = t.indexOf("x"), dist = d.get(tt);
            int x = p / 3, y = p % 3;
            for (int i = 0; i < 4; i++) {
                int a = dx[i] + x, b = dy[i] + y;
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    swap(t, p, a * 3 + b);
                    if (!d.containsKey(t.toString())) {
                        d.put(t.toString(), dist + 1);
                        q.offer(t.toString());
                    }
                    swap(t, p, a * 3 + b); // 恢复状态
                }
            }
        }
        return -1;
    }

    public static void swap(StringBuilder s, int i, int j) {
        char t = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, t);
    }
}
