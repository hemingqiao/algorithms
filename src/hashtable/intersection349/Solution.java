package src.hashtable.intersection349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 19:42:43
 * description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 *
 * 参考
 * see: https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/zhi-jie-ji-suan-he-pai-xu-yi-ji-er-fen-fa-cha-zhao/
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) resSet.add(j);
        }
        // 将set转为数组返回
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int k : resSet) {
            res[i++] = k;
        }
        return res;
    }
}
