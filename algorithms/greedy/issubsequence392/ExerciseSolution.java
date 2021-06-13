package blogandquestion.algorithms.greedy.issubsequence392;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/13 15:10:16
 * description:
 */
public class ExerciseSolution {
    // 可用双指针求解
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int a = ss.length, b = tt.length;
        if (a > b) return false;
        int i = 0, j = 0;
        for (; i < a; i++) {
            char temp = ss[i];
            while (j < b && tt[j] != temp) j++;
            if (j == b) break;
            j++;
        }
        return i == a && j <= b;
    }


    // 这个解法妙啊
    public boolean isSubsequence1(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int a = ss.length, b = tt.length;
        int i = 0, j = 0;
        while (i < a && j < b) {
            if (ss[i] == tt[j]) ++i;
            ++j;
        }
        return i == a;
    }
}
