package src.binary.reversebits190;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 12:46:53
 * description:
 * 参考：https://leetcode-cn.com/problems/reverse-bits/solution/zhi-qi-ran-zhi-qi-suo-yi-ran-wei-yun-suan-jie-fa-x/
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，
 * 输出表示有符号整数 -1073741825。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 *
 */
public class Solution {
    // 还需要考虑溢出等问题，最好全部使用位运算
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res * 2 + n % 2;
            // -3 / 2 = -1 而 -3 >> 1 = -2
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.reverseBits(-3);
        System.out.println(res);
    }

    public int reverseBitsOpt(int n) {
        // 考虑到溢出，以及Java负数除以2会向0取整（-3 / 2 = -1 而 -3 >> 1 = -2）
        // 最好全部使用位运算
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
