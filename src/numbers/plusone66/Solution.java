package src.numbers.plusone66;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 15:47:31
 * description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 *
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        String res = addStrings(sb.toString(), "1");
        int[] result = new int[res.length()];
        int i = 0;
        for (char c : res.toCharArray()) {
            result[i++] = c - '0';
        }
        return result;
    }

    /**
     * 因为整数有范围，所以可以利用字符串进行加法运算
     * @param num1
     * @param num2
     * @return
     */
    private String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--,j--) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            res.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        //int[] test = {0, 0};
        int[] res = s.plusOne(test);
        System.out.println(Arrays.toString(res));
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 */
class AnotherSolution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        // 特判，如99，999之类
        int[] digit = new int[digits.length + 1];
        digit[0] = 1;
        return digit;
    }
}
