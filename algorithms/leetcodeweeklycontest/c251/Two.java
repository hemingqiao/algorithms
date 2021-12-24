package blogandquestion.algorithms.leetcodeweeklycontest.c251;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/25 12:03:28
 * description:
 */
public class Two {
    public String maximumNumber(String num, int[] change) {
        char[] s = num.toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] -= '0';
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= change[s[i]]) {
                continue;
            }
            int j = i;
            while (j < s.length && s[j] <= change[s[j]]) {
                s[j] = (char) change[s[j]];
                j++;
            }
            break;
        }
        for (int i = 0; i < s.length; i++) {
            s[i] += '0';
        }
        return new String(s);
    }
}
