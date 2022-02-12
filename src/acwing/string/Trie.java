package src.acwing.string;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 11:19:29
 * description:
 */
public class Trie {
    public static int N = 100010;
    public static int[][] son = new int[N][26];
    public static int[] cnt = new int[N];
    public static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] ss = in.readLine().split(" ");
            if ("I".equals(ss[0])) insert(ss[1]);
            else System.out.println(query(ss[1]));
        }
    }

    public static void insert(String s) {
        int p = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++; // 字符串s出现的次数加1
    }

    public static int query(String s) {
        int p = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
