package src.smallernumbersthancurrent1365;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/26 19:36:06
 * description: 利用计数排序。
 * 解题思路
 * see: https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/solution/java-pai-xu-yu-ying-she-by-lzhlyle/
 *
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 *
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] frequency = new int[101]; // 记录各个数出现的频率，索引即对应的数值
        for (int num : nums) frequency[num]++;

        for (int i = 1; i < frequency.length; i++) {
            frequency[i] = frequency[i] + frequency[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[i] = frequency[nums[i] - 1];
            }
        }

        return res;
    }


    // 写一个更容易理解的版本
    public int[] smallerThan(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) frequency[num]++; // 统计各个数值出现的频率，索引就是对应的数值

        int[] frequencyBefore = new int[101]; // 统计各个数前面的数出现的频率，存入before数组
        for (int i = 1; i < frequency.length; i++) {
            frequencyBefore[i] = frequency[i] + frequency[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[i] = frequencyBefore[nums[i] - 1];
            }
        }
        return res;
    }
}
