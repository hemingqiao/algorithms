package blogandquestion.algorithms.string.convert6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/11 21:27:43
 * description:
 */
public class ExerciseSolution {
    public String convert(String s, int numRows) {
        // 进行特判，如果行数为1，直接返回（不然会在下面的逻辑中出错）
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int p = 0, flag = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            list.get(p).append(s.charAt(i));
            if (p == 0 || p == numRows - 1) flag = -flag;
            p += flag;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : list) ret.append(sb);
        return ret.toString();
    }
}
