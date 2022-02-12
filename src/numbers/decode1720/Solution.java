package src.numbers.decode1720;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/06 09:51:00
 * description:
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 *
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *  
 *
 * 提示：
 *
 * 2 <= n <= 10^4
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 10^5
 * 0 <= first <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 *
 */
public class Solution {
    /*
    核心思想：如果 a ^ b = c, 那么有 a = b ^ c, b = a ^ c
    arr[i] ^ arr[i + 1] = encoded[i]
        0 ^ 0 -> 0
        0 ^ 1 -> 1
        1 ^ 0 -> 1
        1 ^ 1 -> 0
    不难发现：arr[i + 1] = arr[i] ^ encoded[i]
            arr[i] = arr[i + 1] ^ encoded[i]
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ret = new int[n + 1];
        ret[0] = first;
        for (int i = 0; i < n; i++) {
            // 以origin表示原数组，根据异或的性质和题意：origin[0] ^ origin[1] = encoded[0] => origin[0] ^ origin[1] ^ origin[0] = encoded[0] ^ origin[0]
            // 而origin[0] ^ origin[1] ^ origin[0] == origin[1]
            // 所以有 origin[2] = encoded[1] ^ origin[1]
            ret[i + 1] = ret[i] ^ encoded[i];
        }
        return ret;
    }
}
