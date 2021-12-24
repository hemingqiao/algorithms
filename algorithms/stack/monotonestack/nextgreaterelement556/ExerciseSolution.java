package blogandquestion.algorithms.stack.monotonestack.nextgreaterelement556;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/24 09:59:17
 * description:
 */
public class ExerciseSolution {
    public int nextGreaterElement(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int k = n - 1;
        while (k > 0 && chars[k - 1] >= chars[k]) k--;
        if (k <= 0) return -1;
        int t = k;
        while (t < n && chars[t] > chars[k - 1]) t++;
        swap(chars, k - 1, t - 1);
        reverse(chars, k, n - 1);
        long res = Long.parseLong(String.valueOf(chars));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    public void reverse(char[] c, int l, int r) {
        while (l < r) swap(c, l++, r--);
    }

    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
