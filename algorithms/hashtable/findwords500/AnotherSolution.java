package blogandquestion.algorithms.hashtable.findwords500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/02 16:30:22
 * description:
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 *
 */
public class AnotherSolution {
    // 把代码改的好看一点
    public String[] findWords(String[] words) {
        char[] r1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', };
        char[] r2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] r3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Map<Character, Integer> rows = new HashMap<>();
        for (char c : r1) rows.put(c, 1);
        for (char c : r2) rows.put(c, 2);
        for (char c : r3) rows.put(c, 3);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int one = 0, two = 0, three = 0;
            for (char c : chars) {
                if (c < 'a') c += 32;
                if (rows.get(c) == 1) one = 1;
                if (rows.get(c) == 2) two = 1;
                if (rows.get(c) == 3) three = 1;
                if (one + two + three > 1) break;
            }
            if (one + two + three == 1) res.add(word);
        }
        // 转为数组输出
        String[] ret = new String[res.size()];
        int p = 0;
        for (String str : res) {
            ret[p++] = str;
        }
        return ret;
    }
}
