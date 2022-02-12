package src.doublepointer.equalsubstring1208;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/05 08:54:43
 * description:
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 *
 * 参考：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/cyu-yan-liang-chong-jie-fa-hua-chuang-qi-hjy3/
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int n = ss.length;
        int res = 0;
        int cost = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            cost += Math.abs(ss[j] - tt[j]);
            while (cost > maxCost) {
                cost -= Math.abs(ss[i] - tt[i]);
                i++; // 窗口收缩，最左边向右移动一位
            }
            res = Math.max(res, j - i + 1); // 窗口右指针每向右移动一位，就更新一次结果
        }
        return res;
    }
}
