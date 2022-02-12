package src.binary.decode1734;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/11 19:11:59
 * description:
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 10^5
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 *
 * 参考：https://leetcode-cn.com/problems/decode-xored-permutation/solution/shu-ju-jie-gou-he-suan-fa-jie-ma-yi-huo-6wbiv/
 */
public class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int allXor = 0;
        for (int i = 1; i <= n + 1; i++) allXor ^= i;
        int evenXor = 0;
        for (int i = 1; i < n; i += 2) evenXor ^= encoded[i];
        int start = allXor ^ evenXor;
        int[] ret = new int[n + 1];
        ret[0] = start;
        for (int i = 0; i < n; i++) {
            ret[i + 1] = ret[i] ^ encoded[i];
        }
        return ret;
    }
}
