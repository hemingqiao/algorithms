package blogandquestion.algorithms.binary.countnumberone191;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 08:38:15
 * description:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 *
 * 参考
 * https://mp.weixin.qq.com/s/MdUPAi7S6MXOf74acWkXWA
 */
public class Solution {
    public int hammingWeight(int n) {
        // 把数字不停的右移，然后和1进行与运算，如果结果为1，表明这个位上的数字是1
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 无符号右移
            if ((n >>> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        // 当右移x位之后，n变为0，无需再进行循环了
        while (n != 0) {
            count += n & 1;
            // 无符号右移
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 还可以将1左移x位，判断n与上1左移x位后的值是否等于0
            if ((n & (1 << i)) != 0) count++;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        // n & (n-1)可以把n右边的1消掉
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test = 7;
        int res = s.hammingWeight3(-99);
        System.out.println(res);
    }
}
