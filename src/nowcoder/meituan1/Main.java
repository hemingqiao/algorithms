package src.nowcoder.meituan1;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/07 20:29:12
 * description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int[] books = new int[10001];
        boolean[] locked = new boolean[10001]; // 标识第i行是否上锁
        boolean[] lend = new boolean[10001]; // 表示书是否被借
        int Q = Integer.parseInt(firstLine[2]);
        for (int i = 0; i < Q; i++) {
            String[] line = br.readLine().split(" ");
            int[] ops = new int[line.length];
            for (int j = 0; j < line.length; j++) ops[j] = Integer.parseInt(line[j]);
            switch (ops[0]) {
                case 1:
                    if (locked[ops[2]]) break;
                    if (lend[ops[1]]) break;
                    // 如果这本书在一行上了锁的书架上，操作无效
                    if (books[ops[1]] != 0 && locked[books[ops[1]]]) break;
                    books[ops[1]] = ops[2]; // 编号为x的书（索引为x），其值为所处的行
                    break;
                case 2:
                    locked[ops[1]] = true;
                    break;
                case 3:
                    locked[ops[1]] = false;
                    break;
                case 4:
                    // 如果x已经放在了书架上，且该层书架又没上锁，直接输出
                    if (books[ops[1]] != 0 && !locked[books[ops[1]]]) {
                        System.out.println(books[ops[1]]);
                        books[ops[1]] = 0;
                        lend[ops[1]] = true;
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 5:
                    if (!lend[ops[1]]) break; // 如果该编号的书没有被借走，还书无效
                    lend[ops[1]] = false;
                    break;
            }
        }
    }
}

class Main1 {
    /*
    小美喜欢字母E，讨厌字母F。在小美生日时，小团送了小美一个仅包含字母E和F的字符串，小美想从中选出一个包含字母E数量与字母F数量之差最大的子串。

    *子串：从字符串前面连续删去若干个字符，从后面连续删去若干个字符剩下的字符串（也可以一个都不删），例如abcab是fabcab的子串，而不是abcad的子串。我们将空串看作所有字符串的子串。

    输入描述:
    第一行一个正整数n表示字符串的长度。

    第二行长度为n，且仅包含大写字母’E’,’F’的字符串（不含引号）

    输出描述:
    输出一个整数，表示最大的差值


    输入例子1:
    5
    EFEEF

    输出例子1:
    2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] chars = str.toCharArray();
        int res = 0;
        /*
        // TLE
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[2];
            for (int j = i; j < n; j++) {
                cnt[chars[j] - 'E']++;
                res = Math.max(res, cnt[0] - cnt[1]);
            }
        }
        */
        int[] dp = new int[n];
        dp[0] = chars[0] == 'E' ? 1 : -1;
        for (int i = 1; i < n; i++) {
            int num = chars[i] == 'E' ? 1 : -1;
            dp[i] = dp[i - 1] < 0 ? num : dp[i - 1] + num;
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
