package src.binary.countbits338;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 17:01:09
 * description:
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 *
 * 奇数x的二进制数中的1比x-1的二进制数中的1多一个，偶数加上一个1成为和偶数相邻的奇数，
 * 偶数y的二进制数中1的个数和y / 2的二进制数中1的个数相同，因为y / 2 右移一位得到y，右移一位低位补0
 * 0的二进制数中1的个数为0
 * 参考：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            // 偶数
            if ((i & 1) == 0) {
                res[i] = res[i >> 1];
            } else {
                // 奇数
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}
