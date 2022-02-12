package src.acwing.contest.nine;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/24 21:59:04
 * description:
 * 给定一个长度为 n 的数组 a1,a2,…,an，其中 ai=i。
 *
 * 现在，请你选择一个整数 m，并对该数组进行 m 次操作。
 *
 * 对于第 i 次操作（i 从 1 开始计数），你需要选定其中一个元素，并将选定元素以外的其他所有元素都增加 i。
 *
 * 你的目标是在 m 次操作结束后，数组中各个元素的值都相等。
 *
 * m 不得超过 1000。
 *
 * 请你输出具体合理方案。
 *
 * 输入格式
 * 第一行包含整数 T，表示共有 T 组测试数据。
 *
 * 每组数据占一行，包含一个整数 n。
 *
 * 输出格式
 * 每组数据输出占两行。
 *
 * 第一行输出操作次数 m。
 *
 * 第二行输出 m 个整数 p1,p2,…,pn，其中 pi 表示第 i 次操作选中的元素的编号。
 *
 * 保证一定有解。
 *
 * 输出任意合理方案均可。
 *
 * 数据范围
 * 本题共两个测试点。
 * 小测试点，如样例所示。
 * 大测试点满足：1≤T≤100，2≤n≤100。
 *
 * 输入样例：
 * 2
 * 2
 * 3
 * 输出样例：
 * 1
 * 2
 * 5
 * 3 3 3 1 2
 */
public class BalanceArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            System.out.println(n);
            for (int i = 1; i <= n; i++) System.out.print(i + " ");
            System.out.println();
        }
    }
}
