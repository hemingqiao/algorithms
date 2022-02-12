package src.string.countandsay38;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/15 22:05:54
 * description:
 */
public class ExerciseSolution1 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder s = new StringBuilder();
        String pre = countAndSay(n - 1);
        int len = pre.length();
        for (int i = 0, j = 0; i < len; i++) {
            char c = pre.charAt(i);
            while (j < len && pre.charAt(j) == c) j++;
            s.append(j - i).append(c);
            i = j - 1;
        }
        return s.toString();
    }

    public String countAndSay1(int n) {
        StringBuilder s = new StringBuilder("1");
        while (--n > 0) {
            StringBuilder t = new StringBuilder();
            int len = s.length();
            for (int i = 0, j = 0; i < len; i++) {
                char c = s.charAt(i);
                while (j < len && s.charAt(j) == c) j++;
                t.append(j - i).append(c);
                i = j - 1;
            }
            s = t;
        }
        return s.toString();
    }
}
