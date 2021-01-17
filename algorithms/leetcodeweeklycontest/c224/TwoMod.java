package blogandquestion.algorithms.leetcodeweeklycontest.c224;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 11:27:33
 * description:
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (3,4,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 *
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * 示例 3：
 *
 * 输入：nums = [2,3,4,6,8,12]
 * 输出：40
 * 示例 4：
 *
 * 输入：nums = [2,3,5,7]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tuple-with-same-product
 *
 */
public class TwoMod {
    // 每两组乘积相同的数据可以排列出8种不同的组合，因此当有n组乘积相同的数据时，最终的结果是 C(n,2) * 8 <=> n * (n - 1) / 2 * 8
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = nums[i] * nums[j];
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 1);
                }
            }
        }
        for (int value : map.values()) {
            ret += value * (value - 1) / 2;
        }
        return ret * 8;
    }
}
