package blogandquestion.algorithms.acwing.monotonic;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/22 23:08:55
 * description:
 *
 */
public class MonoQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] first = in.readLine().split(" ");
        int n = Integer.parseInt(first[0]), k = Integer.parseInt(first[1]);
        int[] qq = new int[n];
        String[] ss = in.readLine().split(" ");
        Deque<Integer> q = new ArrayDeque<>();
        // 输出窗口内最小值
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(ss[i]);
            qq[i] = x;
            if (!q.isEmpty() && q.peek() <= i - k) q.poll();
            while (!q.isEmpty() && qq[q.peekLast()] >= x) q.pollLast();
            q.offer(i);
            if (i >= k - 1) System.out.print(qq[q.peek()] + " ");
        }
        System.out.println();
        q = new ArrayDeque<>();
        // 输出窗口内的最大值
        for (int i = 0; i < n; i++) {
            int x = qq[i];
            if (!q.isEmpty() && q.peek() <= i - k) q.poll();
            while (!q.isEmpty() && qq[q.peekLast()] <= x) q.pollLast();
            q.offer(i);
            if (i >= k - 1) System.out.print(qq[q.peek()] + " ");
        }
    }
}
