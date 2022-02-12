package src.array.sortarraybyparity905;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 22:21:11
 * description:
 * 定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 *
 */
public class Solution {
    // n & 1 == 1 表明n为奇数，否则n为偶数
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = A.length - 1;
        for (int num : A) {
            if ((num & 1) == 1) {
                // 奇数
                res[r--] = num;
            } else {
                res[l++] = num;
            }
        }
        return res;
    }
}
