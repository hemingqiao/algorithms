package blogandquestion.algorithms.numbers.findduplicate287;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 11:46:26
 * description:
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 *
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        // 暴力解法，双重for循环，执行时间374ms，击败5%
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {3,1,3,4,2};
        int result = s.findDuplicate(test);
        System.out.println(result);
    }

    // 如果先对数组排序呢
    // 执行时间降到了3ms
    public int findDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

    // 使用hash结构来判断
    // 执行时间3ms
    public int findDuplicateHash(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
