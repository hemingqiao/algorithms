package blogandquestion.algorithms.topk.kweakestrows1337;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/01 09:08:47
 * description:
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[] ret = new int[k];
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) sum += mat[i][j];
            p[i] = new Pair(i, sum);
        }
        Arrays.sort(p, (a, b) -> {
            if (a.num == b.num) return a.row - b.row;
            return a.num - b.num;
        });
        for (int i = 0; i < k; i++) ret[i] = p[i].row;
        return ret;
    }

    static class Pair {
        int row;
        int num;

        public Pair(int row, int num) {
            this.row = row;
            this.num = num;
        }
    }

    // 求最小的k个值则是会使用大顶堆
    public int[] kWeakestRows1(int[][] mat, int k) {
        int n = mat.length;
        int[] ret = new int[k];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.num == b.num ? b.row - a.row : b.num - a.num);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) sum += mat[i][j];
            q.offer(new Pair(i, sum));
            if (q.size() > k) q.poll();
        }
        int p = k;
        while (!q.isEmpty()) ret[--k] = q.poll().row;
        return ret;
    }
}
