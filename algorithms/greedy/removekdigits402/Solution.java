package blogandquestion.algorithms.greedy.removekdigits402;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/11 18:15:22
 * description:
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 *
 * 参考：https://leetcode-cn.com/problems/remove-k-digits/comments/100312
 * 参考：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
 */
public class Solution {
    // 从左到右，找到第一个比后面大的字符，删除，并去除前导的零，重复k次
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            while (idx < s.length() - 1 && s.charAt(idx) <= s.charAt(idx + 1)) {
                idx++;
            }
//            s.deleteCharAt(idx); // 效果相同
            s.delete(idx, idx + 1);
            // 去除前导的0
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }
}
