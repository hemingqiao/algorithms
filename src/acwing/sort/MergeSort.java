package src.acwing.sort;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/23 21:21:19
 * description:
 */
public class MergeSort {
    public static int N = 100010;
    public static int[] q = new int[N];
    public static int[] temp = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] ss = in.readLine().split(" ");
        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(ss[i]);
        mergeSort(q, 0, n - 1);
        for (int i = 0; i < n; i++) System.out.print(q[i] + " ");
    }

    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) temp[k++] = q[i++];
            else temp[k++] = q[j++];
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];
        while (k-- > 0) q[k + l] = temp[k];
    }
}
