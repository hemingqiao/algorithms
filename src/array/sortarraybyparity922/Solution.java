package src.array.sortarraybyparity922;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 22:27:10
 * description:
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 *
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = 1;
        for (int num : A) {
            if ((num & 1) == 1) {
                // 奇数
                res[j] = num;
                j += 2;
            } else {
                res[i] = num;
                i += 2;
            }
        }
        return res;
    }
}
