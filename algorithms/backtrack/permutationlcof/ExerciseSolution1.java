package blogandquestion.algorithms.backtrack.permutationlcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 11:47:30
 * description:
 */
public class ExerciseSolution1 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n = chars.length;
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(res, chars, used, new StringBuilder());
        return res.toArray(new String[0]);
    }

    public void backtrack(List<String> list, char[] chars, boolean[] used, StringBuilder s) {
        if (s.length() == chars.length) {
            list.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue; // 去重
            if (!used[i]) {
                used[i] = true;
                s.append(chars[i]);
                backtrack(list, chars, used, s);
                s.deleteCharAt(s.length() - 1);
                used[i] = false;
            }
        }
    }
}
