package blogandquestion.algorithms.binary.hammingdistance461;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 11:36:58
 * description:
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 *
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        // 题目限定了是整型，共32位
        // 这个通过了，但是如果比较了32位，符号位也比较了吧？
        for (int i = 0; i < 32; i++) {
            // 比较的二进制位上的距离，可以通过模2来获得每个位上的值
            if (Math.abs((x % 2) - (y % 2)) == 1) {
               distance++;
            }
            x /= 2;
            y /= 2;
        }
        return distance;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int distance = s.hammingDistance(1, 4);
        System.out.println(distance);
    }
}

/**
 * 位运算。
 * n & (n-1)作用：将n的二进制表示中的最低位为1的改为0。
 * 参考：https://blog.csdn.net/navyifanr/article/details/19496459
 */
class AnotherSolution {
    public int hammingDistance(int x, int y) {
        // 异或运算将两个二进制数的不同的1合并到1个数上面（异或：相同为0，不同为1）
        // 如 1 ^ 4 => 0001 ^ 0100 == 0101
        // 再利用n & n - 1 统计出所有1的个数
        int n = x ^ y;
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
