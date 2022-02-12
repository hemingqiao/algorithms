package src.backtrack.restoreipaddresses93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 18:43:31
 * description:
 * 二刷，这题掌握的很不好
 */
public class ExerciseSolution {
    // 这暴力解法恐怖如斯，击败了82%😱
    public List<String> restoreIpAddress(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int a = 1; a < 4; a++)
        for (int b = 1; b < 4; b++)
        for (int c = 1; c < 4; c++)
        for (int d = 1; d < 4; d++)
            if (a + b + c + d == n) {
                int A = Integer.parseInt(s.substring(0, a));
                int B = Integer.parseInt(s.substring(a, a + b));
                int C = Integer.parseInt(s.substring(a + b, a + b + c));
                int D = Integer.parseInt(s.substring(a + b + c));
                if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                    StringBuilder t = new StringBuilder();
                    t.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                    if (t.length() == n + 3) res.add(t.toString());
                }
            }
        return res;
    }

    public List<String> restoreIpAddress1(String s) {
        List<String> res = new ArrayList<>();
        help(s, 0, "", res);
        return res;
    }

    public void help(String s, int n, String ret, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(ret);
            return;
        }
        for (int k = 1; k < 4; k++) {
            // 字符串剩余长度小于k，就不需要进行分割了
            if (s.length() < k) break;
            int temp = Integer.parseInt(s.substring(0, k));
            if (temp > 255 || String.valueOf(temp).length() != k) continue;
            StringBuilder t = new StringBuilder();
            help(s.substring(k), n + 1,
                    t.append(ret).append(s, 0, k).append(n == 3 ? "" : ".").toString(), res);
        }
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "1111111111111111111111111111";
        List<String> res = es.restoreIpAddress1(test);
        System.out.println(res);
    }
}
