package blogandquestion.algorithms.doublepointer.checkInclusion567;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/10 08:54:30
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/567
 */
public class ExerciseSolution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        // 题目要求判定s2中是否包含s1的排列，如果s1的长度大于s2的长度，那么s2不可能包含s1的排列
        if (n1 > n2) return false;
        int[] cnt1 = new int[128], cnt2 = new int[128];
        for (int i = 0; i < n1; i++) {
            cnt1[s1.charAt(i)]++;
            cnt2[s2.charAt(i)]++;
        }
        if (isEqual(cnt1, cnt2)) return true;
        for (int j = n1; j < n2; j++) {
            cnt2[s2.charAt(j)]++;
            cnt2[s2.charAt(j - n1)]--;
            if (isEqual(cnt1, cnt2)) return true;
        }
        return false;
    }

    public boolean isEqual(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // 从上面的11ms优化到下面这种写法的3ms
    public boolean checkInclusion1(String s1, String s2) {
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        int n1 = chars1.length, n2 = chars2.length;
        if (n1 > n2) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt1[chars1[i] - 'a']++;
            cnt2[chars2[i] - 'a']++;
        }
        if (isEqual(cnt1, cnt2)) return true;
        for (int j = n1; j < n2; j++) {
            cnt2[chars2[j] - 'a']++;
            cnt2[chars2[j - n1] - 'a']--;
            if (isEqual(cnt1, cnt2)) return true;
        }
        return false;
    }
}
