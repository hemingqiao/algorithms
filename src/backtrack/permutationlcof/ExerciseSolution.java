package src.backtrack.permutationlcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/24 09:50:50
 * description:
 * 参考：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/comments/515313
 */
public class ExerciseSolution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        backtrack(res, chars, 0);
        return res.toArray(new String[0]);
    }

    public void backtrack(List<String> list, char[] chars, int depth) {
        if (depth == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int i = depth; i < chars.length; i++) {
            boolean flag = true;
            // 去重判断
            for (int j = depth; j < i; j++) {
                if (chars[j] == chars[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                swap(chars, depth, i);
                backtrack(list, chars, depth + 1);
                swap(chars, depth, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
