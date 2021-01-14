package blogandquestion.algorithms.array.prefixesdivbyfive1018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/14 09:54:18
 * description:
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 *
 * 参考：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/solution/gei-chu-xue-de-xiao-bai-jiang-jie-by-xiao-vvvvvv/
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        int num = 0;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num = (num * 2 + A[i]) % 5;
            if (num % 5 == 0) list.add(true);
            else list.add(false);
        }
        return list;
    }

    // 两者效率相差无几
    public List<Boolean> prefixesDivBy5MOD(int[] A) {
        int n = A.length;
        int num = 0;
        Boolean[] ret = new Boolean[n];
        for (int i = 0; i < n; i++) {
            num = (num * 2 + A[i]) % 5;
            ret[i] = num % 5 == 0;
        }
        return Arrays.asList(ret);
    }
}
