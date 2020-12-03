package blogandquestion.algorithms.binary.getsum371;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/03 10:05:35
 * description:
 * 不使用运算符 + 和 -，计算两整数a、b之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 *
 * 参考：https://leetcode-cn.com/problems/sum-of-two-integers/solution/li-yong-wei-cao-zuo-shi-xian-liang-shu-qiu-he-by-p
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.getSum(5, 7);
        System.out.println(res);
    }
}
