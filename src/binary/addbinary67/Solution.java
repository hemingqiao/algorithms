package src.binary.addbinary67;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 14:05:58
 * description:
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 *
 * 这题和addString 415类似，只不过一个是二进制下的字符串加法，一个是十进制下字符串加法。
 */
public class Solution {
    // 这个的速度快上1ms（40%）
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int carry = 0;
        for (int i = c1.length - 1, j = c2.length - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int v1 = i < 0 ? 0 : c1[i] - '0';
            int v2 = j < 0 ? 0 : c2[j] - '0';
            sb.append((v1 + v2 + carry) % 2);
            carry = (v1 + v2 + carry) / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
        System.out.println(new Solution().addBinary1("1010", "1011"));
    }

    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        char[] c1 = a.toCharArray(), c2 = b.toCharArray();
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i < 0 ? 0 : c1[i--] - '0';
            int v2 = j < 0 ? 0 : c2[j--] - '0';
            int sum = v1 + v2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
