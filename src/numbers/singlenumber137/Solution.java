package src.numbers.singlenumber137;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 17:21:35
 * description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）n
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/single-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--31/
 */
public class Solution {
    // 位运算的解法
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }
}


class BruteSolution {
    // 使用hash结构暴力遍历
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
    }
}
