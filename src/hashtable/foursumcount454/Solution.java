package src.hashtable.foursumcount454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 20:39:13
 * description:
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 *
 * 参考
 * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247484222&idx=1&sn=6d8227272e21c08d6b43250a4a1e0799&scene=21#wechat_redirect
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                // 将a和b之和作为键put到map中，对应的值是a和b之和出现的次数
                map.put((a + b), map.getOrDefault((a + b), 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    // 如果map中存在等于-c-d的键(a + b = -c - d => a + b + c + d = 0)
                    // 将这个键对应的值加到count上
                    count += map.get(-c - d);
                }
            }
        }
        return count;
    }
}
