package src.acwing.contest.eleven;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/07 21:25:27
 * description:
 * 给定一个不含前导 0 的正整数 n。
 *
 * 你可以对 n 进行删位操作。
 *
 * 每次操作，可以将 n 的任意一位数字删去，但是需要保证每次操作完成后的数字仍然是不含前导 0 的正整数。
 *
 * 如果想要使得 n 可以成为某个正整数的平方，那么最少需要对 n 进行多少次操作？
 *
 * 输入格式
 * 第一行包含整数 T，表示共有 T 组测试数据。
 *
 * 每组数据占一行，包含一个整数 n。
 *
 * 输出格式
 * 每组数据输出一行结果，表示最少需要的操作次数，如果不可能使 n 变为某个正整数的平方，则输出 −1。
 *
 * 数据范围
 * 前三个测试点满足 1≤n≤10000。
 * 所有测试点满足 1≤T≤10，1≤n≤2×109。
 *
 * 输入样例1：
 * 1
 * 8314
 * 输出样例1：
 * 2
 * 输入样例2：
 * 1
 * 625
 * 输出样例2：
 * 0
 * 输入样例3：
 * 1
 * 333
 * 输出样例3：
 * -1
 *
 * @see https://www.acwing.com/problem/content/3799/
 */
public class Two {
    public static int INF = 0x3f3f3f3f;
    public static int res = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            res = INF;
            char[] a = in.readLine().toCharArray();
            dfs(a, 0, 0, 0);
            System.out.println(res == INF ? -1 : res);
        }
    }

    public static void dfs(char[] a, int p, int t, int x) {
        if (p == a.length) {
            // System.out.println(x);
            int sqrt = (int) Math.sqrt(x * 1.0);
            // 此时x可能为0，因为可能每次都没有选择一个数，使得x还是初始值
            if (x != 0 && sqrt * sqrt == x) res = Math.min(res, t);
            return;
        }
        dfs(a, p + 1, t + 1, x); // 不取当前位置的值，操作次数t加1
        // 当前为的值不为0、或者是x不为0，当前为的值可以为0
        if (a[p] != '0' || (x != 0 && a[p] == '0')) dfs(a, p + 1, t, x * 10 + (a[p] - '0'));
    }
}
