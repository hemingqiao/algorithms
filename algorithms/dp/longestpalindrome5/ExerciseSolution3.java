package blogandquestion.algorithms.dp.longestpalindrome5;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/22 22:21:08
 * description:
 */
public class ExerciseSolution3 {
    public String longestPalindrome(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int left = 0, len = 0;
        for (int i = 0; i < n; i++) {
            // 中心扩散，当回文串长度为奇数时
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < n && a[l] == a[r]) {
                l--;
                r++;
            }
            // r - 1 - (l + 1) + 1 => r - l - 1
            if (r - l - 1 > len) {
                len = r - l - 1;
                left = l + 1;
            }
            // 当回文串长度为偶数时
            l = i - 1;
            r = i;
            while (l >= 0 && r < n && a[l] == a[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > len) {
                len = r - l - 1;
                left = l + 1;
            }
        }
        return s.substring(left, left + len);
    }
}
