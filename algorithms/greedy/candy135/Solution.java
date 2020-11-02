package blogandquestion.algorithms.greedy.candy135;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/02 14:28:24
 * description: 这里的贪心策略为，再每次遍历中，只考虑并更新相邻一侧的大小关系。
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 *
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) return 0;
        int size = ratings.length;
        if (size < 2) {
            return size;
        }
        int[] nums = new int[size];
        Arrays.fill(nums, 1);
        for (int i = 0; i < size - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        for (int i = size - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        // return Arrays.stream(nums).reduce(0, Integer::sum); // 非常耗时
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
