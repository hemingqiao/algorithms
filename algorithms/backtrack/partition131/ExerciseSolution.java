package blogandquestion.algorithms.backtrack.partition131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/07 11:25:34
 * description:
 * 二刷
 */
public class ExerciseSolution {
    List<List<String>> list = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if ("".equals(s)) return list;
        backtrack(s, 0);
        return list;
    }

    public void backtrack(String s, int startIndex) {
        if (startIndex >= s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 只有当前字串是回文的时候，才进入下一层递归，否则跳过这个i
            if (isPalindrome(s, startIndex, i)) {
                String sub = s.substring(startIndex, i + 1);
                path.add(sub);
                backtrack(s, i + 1);
                path.remove(path.size() - 1); // 回溯
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}

class ExerciseSolution1 {
    List<List<String>> list = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        backtrack(chars, 0);
        return list;
    }

    public void backtrack(char[] chars, int startIndex) {
        if (startIndex >= chars.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            if (isPalindrome(chars, startIndex, i)) {
                String sub = String.valueOf(chars, startIndex, i - startIndex + 1);
                path.add(sub);
                backtrack(chars, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) return false;
        }
        return true;
    }
}
