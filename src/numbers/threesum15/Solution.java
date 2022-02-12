package src.numbers.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 21:24:58
 * description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/r5cgZFu0tv4grBAexdcd8A
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 对数组排序（升序）
        Arrays.sort(nums);
        // i负责最外层遍历，在内层则使用双指针来查找
        // 其中left指针初始时指向i + 1，right指针指向最后一个元素
        for (int i = 0; i < nums.length; i++) {
            // 如果排过序的数组的第一个元素大于0，那么无论如何也不可能凑出三元组之和为0，此时直接返回res
            if (nums[i] > 0) return res;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 因为数组是升序的，如果大于零，证明right指针需要左移
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    // 找到三数之和为0时进行去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // 去重之后，左右指针收缩
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
