package src.numbers.singlenumber136;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/02 22:23:07
 * description: 使用哈希表。时间效率很低。
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/single-number/solution/xue-suan-fa-jie-guo-xiang-dui-yu-guo-cheng-bu-na-y/
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            // 使用值作为map的键，出现次数作为键对应的值
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) { // 如果某个键对应的值为1，表明找到了只出现一次的数
                return i;
            }
        }
        return -1; // 没有找到，返回-1
    }
}
