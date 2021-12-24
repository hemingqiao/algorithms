package blogandquestion.algorithms.acwing.contest.nine;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/24 22:19:32
 * description:
 * @see https://www.acwing.com/problem/content/description/3782/
 */
public class EqualSum {
    public static int N = 200010;
    public static int[] q = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i <= T; i++) {
            int n = in.nextInt(), sum = 0;
            for (int j = 1; j <= n; j++) {
                q[j] = in.nextInt();
                sum += q[j];
            }
            for (int j = 1; j <= n; j++) {
                int x = sum - q[j];
                if (map.containsKey(x) && map.get(x).row != i) {
                    System.out.println("YES");
                    System.out.println(map.get(x).row + " " + map.get(x).col);
                    System.out.println(i + " " + j);
                    return;
                }
                map.put(x, new Pair(i, j));
            }
        }
        System.out.println("NO");
    }

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
