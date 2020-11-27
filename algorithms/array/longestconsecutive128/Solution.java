package blogandquestion.algorithms.array.longestconsecutive128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 19:43:10
 * description:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 *
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int maxLen = 1, ans = 1;
        Arrays.sort(nums);
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) {
                maxLen++;
                ans = Math.max(ans, maxLen);
            } else {
                // 如果序列不再连续，将maxLen重置为1
                maxLen = 1;
            }
        }
        return ans;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/longest-consecutive-sequence/comments/91744
 */
class AnotherSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            // 搜索的同时从set中删除元素
            if (set.remove(num)) {
                int currentLen = 1;
                int cur = num;
                // 向num的左边搜索，如num为100，搜索set中是否存在99，98等
                while (set.remove(cur - 1)) cur--;
                currentLen += num - cur;
                // 向num的右边搜索，如num为100，搜索set中是否存在101，102等
                cur = num;
                while (set.remove(cur + 1)) cur++;
                currentLen += cur - num;
                // 向两边搜索完之后更新最大值
                ans = Math.max(ans, currentLen);
            }
        }
        return ans;
    }
}
