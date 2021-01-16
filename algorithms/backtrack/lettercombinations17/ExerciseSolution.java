package blogandquestion.algorithms.backtrack.lettercombinations17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 20:34:48
 * description:
 */
public class ExerciseSolution {
    public List<String> letterCombinations(String digits) {
        String[][] map = new String[][]{
                {""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
                {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"},
                {"t", "u", "v"}, {"w", "x", "y", "z"}
        };
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if (len == 0) return list;
        backtracking(list, digits, map, 0, len, "");
        return list;
    }

    public void backtracking(List<String> list, String digits, String[][] map, int index, int len, String t) {
        if (index == len) {
            list.add(t);
            return;
        }
        int c = digits.charAt(index) - '0';
        String[] m = map[c];
        for (int i = 0; i < m.length; i++) {
            t = t + m[i];
            backtracking(list, digits, map, index + 1, len, t);
            t = t.substring(0, t.length() - 1);
        }
    }
}

class ExerciseSolution1 {
    // 将字符串拼接改为使用StringBuilder，确实要快上不少
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return new ArrayList<>();
        String[][] map = new String[][]{
                {""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
                {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"},
                {"t", "u", "v"}, {"w", "x", "y", "z"}
        };
        List<String> list = new ArrayList<>();
        backtracking(list, map, digits, 0, new StringBuilder(), len);
        return list;
    }

    public void backtracking(List<String> list, String[][] map, String digits, int index, StringBuilder s, int len) {
        if (index == len) {
            list.add(s.toString());
            return;
        }
        int c = digits.charAt(index) - '0';
        String[] m = map[c];
        for (int i = 0; i < m.length; i++) {
            s.append(m[i]);
            backtracking(list, map, digits, index + 1, s, len);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
