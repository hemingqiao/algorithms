package blogandquestion.algorithms.array.partitiondisjoint915;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/30 22:21:37
 * description:
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
 *
 * 参考：https://github.com/grandyang/leetcode/issues/915
 */
public class Solution {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] backMin = new int[n];
        Arrays.fill(backMin, A[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            backMin[i] = Math.min(backMin[i + 1], A[i]);
        }
        int max = A[0];
        for (int j = 0; j < n; j++) {
            max = Math.max(max, A[j]);
            // 注意这里，是和右边的最小值数组中的j + 1项作比较
            if (max <= backMin[j + 1]) return j + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 0, 3, 8, 6};
        int res = new Solution().partitionDisjoint(test);
        System.out.println(res);
    }
}
