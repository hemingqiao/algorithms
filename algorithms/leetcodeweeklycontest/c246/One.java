package blogandquestion.algorithms.leetcodeweeklycontest.c246;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 19:24:12
 * description:
 */
public class One {
    public String largestOddNumber(String num) {
        int n = num.length();
        if ((int) num.charAt(n - 1) % 2 == 1) return num;
        for (int i = n - 2; i >= 0; i--) {
            int a = (int) num.charAt(i);
            if (a % 2 == 1) return num.substring(0, i + 1);
        }
        return "";
    }
}
