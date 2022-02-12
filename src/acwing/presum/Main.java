package src.acwing.presum;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/01 22:30:47
 * description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        /*int n = 3, m = 4, q = 1;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = i + j;
            }
        }*/
//        System.out.println(Arrays.deepToString(nums));
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }
        while (q-- > 0) {
            int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
//            int x1 = 1, y1 = 3, x2 = 3, y2 = 4;
            System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
        }
    }
}
