package src.string.reversestring344;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 20:00:10
 * description:
 */
public class AnotherSolution {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        char temp;
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
