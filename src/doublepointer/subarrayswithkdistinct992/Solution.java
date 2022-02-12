package src.doublepointer.subarrayswithkdistinct992;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/09 13:32:25
 * description:
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 *
 */
public class Solution {
    // 暴力解法TLE
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(A[j]);
                if (set.size() == K) res++;
            }
        }
        return res;
    }

    // 不明白
    // 参考：https://github.com/grandyang/leetcode/issues/992
    public int subarraysWithKDistinct1(int[] A, int K) {
        return helper(A, K) - helper(A, K - 1);
    }

    /**
     * 这个方法的作用是计算整数数量小于k的子数组的数量和，既整数数量为1,2,3.......k的子数组数的和，k-1同理，返回值为整数数量
     * 为1,2,3.......k-1的子数组数的和，两者之差就是整数数量为k的子数组数量。
     *
     * 求“每个同学都有苹果，恰好有 3 个苹果的同学有多少位”，即“拥有 3 个 或 2 个 或 1 个苹果的同学数”减去“拥有 2 个或 1 个苹果的同学数”
     * @param A
     * @param K
     * @return
     */
    public int helper(int[] A, int K) {
        int n = A.length;
        int left = 0, res = 0;
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 如果当前的数字没有出现过，K自减1
            if (!numCnt.containsKey(A[i]) || numCnt.get(A[i]) == 0) --K;
            if (numCnt.containsKey(A[i])) {
                numCnt.put(A[i], numCnt.get(A[i]) + 1);
            } else {
                numCnt.put(A[i], 1);
            }
            // K的值可能小于0，表明此时窗口内的不同数字过多了，需要移除一个
            while (K < 0) {
                int val = numCnt.get(A[left]);
                numCnt.put(A[left], --val);
                if (val == 0) ++K;
                ++left;
            }
            // left到i区间包含k个不同的数字
            // 要求由最多 K 个不同整数组成的子数组的个数，那么对于长度 [left, right] 区间内的每个子数组都是满足要求的
            // 参考：https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/cong-zui-jian-dan-de-wen-ti-yi-bu-bu-tuo-7f4v/
            res += i - left + 1;
        }
        return res;
    }
}
