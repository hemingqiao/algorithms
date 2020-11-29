package blogandquestion.algorithms.doublepointer.ispalindrome125;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/15 22:22:06
 * description: 双指针，分别从左右两边开始验证。
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 *
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        else if (s.equals("")) return true;

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char l =s.charAt(i);
            char r = s.charAt(j);
            // 判断字符是否是字母和数字(0 <= l - '0' <= 9, 数字)(49 <= l - '0' <= 74, 小写字母)
            // 如果不是字母和数字，直接跳过
            if (l - '0' < 0 || l - '0' > 9 && l - '0' < 49 || l - '0' > 74) {
                i++;
                continue;
            }
            if (r - '0' < 0 || r - '0' > 9 && r - '0' < 49 || r - '0' > 74) {
                j--;
                continue;
            }
            if (l != r) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "A man, a plan, a canal: Panama";
        boolean result = s.isPalindrome(s1);
        System.out.println(result);
    }
}
