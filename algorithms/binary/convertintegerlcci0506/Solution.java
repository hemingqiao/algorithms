package blogandquestion.algorithms.binary.convertintegerlcci0506;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 22:24:24
 * description:
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-lcci
 *
 */
public class Solution {
    public int convertInteger(int A, int B) {
        // 异或运算相同为零，不同为1，所以A和B执行异或运算之后，剩下的1的个数就是需要执行的操作次数
        int N = A ^ B;
        int count = 0;
        while (N != 0) {
            count++;
            N = (N & (N - 1));
        }
        return count;
    }

    // 或者可以直接调用库函数
    public int convertIntegerOpt(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
