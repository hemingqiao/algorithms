package blogandquestion.algorithms.array.prefixsum.numsubarraywithsum930;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 16:41:21
 * description:
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *  
 *
 * 提示：
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 *
 */
public class Solution {
    // 前缀和
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += A[i];
            if (map.containsKey(preSum - S)) cnt += map.get(preSum - S);
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return cnt;
    }

    public int numSubarrayWithSum1(int[] A, int S) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        // 找出所有满足P[j] = P[i] + S 且 i < j 的 i 的数目。 遍历的过程中用map记录当前x与s的和（也就是x+s）出现的次数，那后续的遍历中，
        // 遍历到的新的x从map找到和它相等的key的话就说明了这句“P[j] = P[i] + S”。根据key获得对应的value就是这个x+s的次数
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int p : preSum) {
            if (map.containsKey(p)) cnt += map.get(p);
            if (map.containsKey(p + S)) {
                map.put(p + S, map.get(p + S) + 1);
            } else {
                map.put(p + S, 1);
            }
        }
        return cnt;
    }
}
