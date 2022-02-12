package src.doublepointer.validpalindrome680;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 10:27:53
 * description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 *
 * 参考：https://leetcode-cn.com/problems/valid-palindrome-ii/solution/680-yan-zheng-hui-wen-zi-fu-chuan-ii-jian-ji-shuan/
 */
public class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            if (chars[low] == chars[high]) {
                low++;
                high--;
            } else {
                // 最多只能删除一个元素，可以选择将high向左移动一位，或者是将low向右移动一位
                // 再进行判断
                return isPalindrome(chars, low, high - 1) || isPalindrome(chars, low + 1, high);
            }
        }
        return false;
    }

    public boolean isPalindrome(char[] chars, int low, int high) {
        while (low < high) {
            if (chars[low++] != chars[high--]) return false;
        }
        return true;
    }
}
