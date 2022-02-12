package src.heap.findmaximizedcapital502;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/08 22:10:52
 * description:
 */
public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) p[i] = new Pair(capital[i], profits[i]);
        Arrays.sort(p, (a, b) -> a.first - b.first);
        int res = w, i = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        while (k-- > 0) {
            while (i < n && p[i].first <= res) q.offer(p[i++].second);
            if (q.isEmpty()) break;
            int t = q.poll();
            res += t;
        }
        StringBuilder ss = new StringBuilder();
        ss.delete(ss.length() - 2, ss.length());
        return res;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
