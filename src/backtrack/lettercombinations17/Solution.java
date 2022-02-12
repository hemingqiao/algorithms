package src.backtrack.lettercombinations17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/14 10:01:10
 * description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * 参考
 * https://mp.weixin.qq.com/s/e2ua2cmkE_vpYjM3j6HY0A
 */
public class Solution {
    private String[] map = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtracking(res, "", digits, 0);
        return res;
    }

    private void backtracking(List<String> list, String s, String digits, int index) {
        if (index == digits.length()) {
            list.add(s);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = map[digit];
        for (int i = 0; i < letters.length(); i++) {
            s += letters.charAt(i);
            backtracking(list, s, digits, index + 1);
            s = s.substring(0, s.length() - 1);
        }
        /*
        for (int i = 0; i < letters.length(); i++) {
            // string是不可变的，这里+=实际上是创建了一个新的string对象，所以可以无需进行回溯操作
            backtracking(list, s + letters.charAt(i), digits, index + 1);
        }
        */
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/leetcode-17-letter-combinations-of-a-phone-number-/240594
 */
class AnotherSolution {
    private String[] map = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    // 由于对string进行了频繁的拆箱和装箱，改用了StringBuilder
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), digits, 0);
        return res;
    }

    // index用来记录递归的深度
    private void backtracking(List<String> res, StringBuilder s, String digits, int index) {
        if (index == digits.length()) {
            res.add(s.toString());
            return;
        }

        char c = digits.charAt(index);
        String letters = map[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            //int len = s.length();
            s.append(letters.charAt(i));
            backtracking(res, s, digits, index + 1);
            //s.delete(len, s.length());
            s.deleteCharAt(s.length() - 1); // 回溯，调用deleteCharAt方法时间击败了100%
        }
    }

    public static void main(String[] args) {
        System.out.println(new AnotherSolution().letterCombinations("23"));
    }
}
