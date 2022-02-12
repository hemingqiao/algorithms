package src.string.addstrings415;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 09:17:16
 * description:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 *
 * see: https://leetcode-cn.com/problems/add-strings/solution/4chong-jie-jue-fang-shi-zhi-bu-guo-huan-liao-chong/
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1Arr[i--] - '0';
            int y = j < 0 ? 0 : num2Arr[j--] - '0';
            int sum = x + y + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }

        // 对字符串进行反转
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        // some tests
    }
}
