package src.array.majorityelement229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 19:36:37
 * description:
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n / 3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 *
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int size = nums.length / 3;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) > size && !res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/majority-element-ii/solution/mo-er-tou-piao-fa-jin-jie-ban-by-clearboy/
 */
class AnotherSolution {
    public List<Integer> majorityElement(int[] nums) {
        int res1 = nums[0], res2 = nums[0];
        // 定义两个候选人
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res1) {
                count1++;
            } else if (nums[i] == res2) {
                count2++;
            } else if (count1 == 0) {
                // 当前数与2个候选人都不一样且count等于0则更换候选人
                res1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                res2 = nums[i];
                count2++;
            } else {
                // 非候选人 且 count != 0
                count1--;
                count2--;
            }
        }
        // 题目未保证一定存在2个候选人,因此还需要遍历一次确认是否大于1/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == res1) {
                count1++;
            } else if (num == res2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(res1);
        if (count2 > nums.length / 3) res.add(res2);
        return res;
    }
}
