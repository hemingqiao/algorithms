package src.greedy.removekdigits402;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/28 10:51:19
 * description:
 * 二刷
 * 参考：https://github.com/grandyang/leetcode/issues/402
 */
public class ExerciseSolution {
    public String removeKdigits(String num, int k) {
        // 利用单调栈的思想
        // 维护一个单调递增栈，只要当前的数字大于栈顶元素，就将栈顶元素移除
        StringBuilder s = new StringBuilder();
        char[] chars = num.toCharArray();
        int n = chars.length;
        for (int i = 0; i <= n; i++) {
            // 在字符序列的最后面添加一个字符'0'，当给定字符都是单调递增时，强制出栈k个元素
            char t = i < n ? chars[i] : '0';
            while (k > 0 && s.length() > 0 && s.charAt(s.length() - 1) > t) {
                s.deleteCharAt(s.length() - 1);
                --k;
            }
            s.append(t);
        }
        s.deleteCharAt(s.length() - 1); // 最后要把添加的字符'0'去掉
        while (s.length() > 0 && s.charAt(0) == '0') s.deleteCharAt(0);
        return s.length() == 0 ? "0" : s.toString();
    }
}
