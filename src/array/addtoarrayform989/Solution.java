package src.array.addtoarrayform989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/22 09:59:58
 * description:
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 *
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0 || K != 0; i--) {
            int t = i < 0 ? 0 : A[i];
            int m = K == 0 ? 0 : K % 10;
            K = K == 0 ? 0 : K / 10;
            res.add(0, (t + carry + m) % 10);
            carry = (t + carry + m) / 10;
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

    // 这段代码很简洁
    // 参考：https://github.com/grandyang/leetcode/issues/989
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            res.add((A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K != 0) {
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
