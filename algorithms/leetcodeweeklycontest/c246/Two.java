package blogandquestion.algorithms.leetcodeweeklycontest.c246;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 19:25:12
 * description:
 */
public class Two {
    public int numberOfRounds(String a, String b) {
        int total = 0;
        int h1 = Integer.valueOf(a.substring(0, 2)), h2 = Integer.valueOf(b.substring(0, 2));
        int m1 = Integer.valueOf(a.substring(3, 5)), m2 = Integer.valueOf(b.substring(3, 5));
        if (h1 * 60 + m1 > h2 * 60 + m2) total += 24 * 60;
        if (m1 % 15 != 0) {
            m1 = (m1 + 15) / 15 * 15;
        }
        if (m2 % 15 != 0) {
            m2 = m2 / 15 * 15;
        }
        int res = ((h2 - h1) * 60 + (m2 - m1) + total) / 15;
        return Math.max(res, 0); // 应对 "12:01", "12:02" 这类情况
    }

    public static void main(String[] args) {
        Two t = new Two();
        int res = t.numberOfRounds("12:01", "12:02");
        System.out.println(res);
    }
}
