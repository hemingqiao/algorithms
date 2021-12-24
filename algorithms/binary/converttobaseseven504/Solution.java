package blogandquestion.algorithms.binary.converttobaseseven504;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 18:54:28
 * description:
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 *
 */
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0"; // 特判
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num = -num;
            flag = true;
        }
        while (num > 0) {
            res.append(num % 7);
            num /= 7;
        }
        /*String r = res.reverse().toString();
        if (clicked) return "-" + r;
        return r;*/
        // 尽量避免使用+进行字符串拼接
        if (flag) {
            return res.append("-").reverse().toString();
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(100));
    }
}
