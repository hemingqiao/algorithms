package src.string.backspacecompare844;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 21:20:18
 * description: 逆序读字符串，并且恰好能够避开开头的退格符。
 * 解题思路
 * see: https://leetcode-cn.com/problems/backspace-string-compare/solution/jian-dan-yi-dong-de-0mssuan-fa-zi-fu-chuan-zhong-g/
 */
public class AnotherSolution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        return reverseRead(S).equals(reverseRead(T));
    }

    private String reverseRead(String str) {
        StringBuilder s = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 0; // 记录退格符的数量
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--; // 使用退格符抵消掉字符
                continue;
            }
            s.append(chars[i]); // 退格符为0时添加字符
        }
        return s.toString();
    }
}
