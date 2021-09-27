package blogandquestion.algorithms.dp.numdecodings91;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/27 20:25:51
 * description:
 * 和青蛙爬楼梯很类似
 */
public class ExerciseSolution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char a = s.charAt(i - 1);
            if (a != '0') f[i] += f[i - 1];
            if (i > 1) {
                int t = (s.charAt(i - 2) - '0') * 10 + a - '0';
                if (t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
