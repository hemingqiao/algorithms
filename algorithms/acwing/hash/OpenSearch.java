package blogandquestion.algorithms.acwing.hash;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/18 09:42:33
 * description:
 */
public class OpenSearch {
    // 开放寻址法
    public static int N = 200003;
    public static int[] h = new int[N];
    public static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) h[i] = INF;
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] ss = in.readLine().split(" ");
            String op = ss[0];
            int x = Integer.parseInt(ss[1]);
            int pos = find(x);
            if ("I".equals(op)) {
                h[pos] = x;
            } else {
                if (h[pos] != INF) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    // 如果存在，则返回x的下标
    // 如果不存在，则返回x应该插入的位置
    public static int find(int x) {
        int hash = (x % N + N) % N;
        while (h[hash] != INF && h[hash] != x) {
            hash++;
            if (hash == N) hash = 0;
        }
        return hash;
    }
}
