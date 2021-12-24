package blogandquestion.algorithms.acwing.sort;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/23 22:11:32
 * description:
 * 给定一个长度为 n 的整数数列，请你计算数列中的逆序对的数量。
 *
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i<j 且 a[i]>a[j]，则其为一个逆序对；否则不是。
 *
 * 输入格式
 * 第一行包含整数 n，表示数列的长度。
 *
 * 第二行包含 n 个整数，表示整个数列。
 *
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 6
 * 2 3 4 5 6 1
 * 输出样例：
 * 5
 */
public class ReversePairs {
    public static int N = 100010;
    public static int[] q = new int[N], temp = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] ss = in.readLine().split(" ");
        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(ss[i]);
        System.out.println(mergeSort(0, n - 1));
    }

    public static long mergeSort(int l, int r) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        long res = mergeSort(l, mid) + mergeSort(mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) temp[k++] = q[i++];
            else {
                res += mid - i + 1;
                temp[k++] = q[j++];
            }
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];
        while (k-- > 0) q[k + l] = temp[k];
        return res;
    }
}
