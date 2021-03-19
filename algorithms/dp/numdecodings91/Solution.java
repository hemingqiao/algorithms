package blogandquestion.algorithms.dp.numdecodings91;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/19 12:38:29
 * description:
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 *
 * 参考：https://github.com/grandyang/leetcode/issues/91
 *
 * @see blogandquestion.algorithms.string.translatenumlcof
 * @see blogandquestion.algorithms.nowcoder.newease1.Main
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 长度为 0 的字符串的解码方案为 1
//        dp[1] = 1; // 长度为 1 的字符串的解码方案不能直接定为 1，因为存在唯一的字符是 '0' 的可能，此时 dp[1] == 0
        for (int i = 1; i <= n; i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "10";
        int res = s.numDecodings(test);
        System.out.println(res);
    }
}
