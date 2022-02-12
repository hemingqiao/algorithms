package src.string.lengthOfLongestSubstring3;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/04 21:28:53
 * description:
 */
public class ExerciseSolution2 {
    // 双指针算法
    // 参见：https://www.acwing.com/video/14/
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] a = new int[256];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            a[chars[i]]++;
            while (j < i && a[chars[i]] > 1) {
                a[chars[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] a = new int[256];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            char t = chars[i];
            a[t]++;
            while (a[t] > 1) {
                a[chars[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
