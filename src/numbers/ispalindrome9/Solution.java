package src.numbers.ispalindrome9;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/04 08:52:08
 * description:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 *
 * see: https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // 如果x以0结尾可以直接返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rs = 0;
        while (x > rs) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return x == rs || x == rs / 10; // x可能是奇数位也可能是偶数位
    }

    // 转为字符串的解法
    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
