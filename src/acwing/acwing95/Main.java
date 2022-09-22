package src.acwing.acwing95;

import java.util.*;
import java.io.*;

public class Main {
    static int N = 6;
    static int[][] g = new int[N][N], backup = new int[N][N];
    static int[] dx = {-1, 0, 1, 0, 0}, dy = {0, 1, 0, -1, 0};

    static void turn(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= 5 || b < 0 || b >= 5) continue;
            // 0变成1，1变成0
            g[a][b] ^= 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            for (int i = 0; i < 5; i++) {
                String t = in.readLine();
                for (int j = 0; j < 5; j++)
                    backup[i][j] = t.charAt(j) - '0';
            }
            in.readLine();

            int res = 10;
            // op以二进制位表示对第一行灯的操作
            // 比如op为5，00101，表示按下第一行的第三个和第五个灯，然后枚举对第一行这样操作之后能不能完成题目要求
            for (int op = 0; op < 1 << 5; op++) {
                int cnt = 0; // 记录不同op对应的操作次数

                // 取出备份
                for (int i = 0; i < 5; i++)
                    System.arraycopy(backup[i], 0, g[i], 0, N);

                // 按照op来操作第1行的开关
                for (int i = 0; i < 5; i++)
                    if ((op >> i & 1) == 1) {
                        turn(0, i);
                        ++cnt;
                    }

                // 根据第1行的状态操作下面4行
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 5; j++)
                        // 如果当前位置的开关为0，必须按下下一行的开关，使得当前位置变为1
                        if (g[i][j] == 0) {
                            turn(i + 1, j);
                            ++cnt;
                        }

                boolean success = true;
                for (int i = 0; i < 5; i++)
                    if (g[4][i] == 0)
                        success = false;
                if (success && res > cnt)
                    res = cnt;
            }

            if (res > 6) res = -1;
            System.out.println(res);
        }
    }
}
