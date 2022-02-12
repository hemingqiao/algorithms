package src.array.summaryranges228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 13:31:08
 * description:
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 *
 * 输入：nums = [0]
 * 输出：["0"]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 *
 * 参考：https://leetcode-cn.com/problems/summary-ranges/solution/dai-ma-jian-dan-da-bai-100-by-lllllliuji-2/
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        List<String> res = new ArrayList<>();
        int l = 0; // 左指针初始化为0
        while (l < len) {
            StringBuilder sb = new StringBuilder();
            int r = l;
            // 当值是连续的时候，持续移动右指针
            while (r + 1 < len && nums[r + 1] == nums[r] + 1) {
                r++;
            }
            if (l == r) {
                // l == r 可能代表到达边界
                res.add(sb.append(nums[l]).toString());
            } else {
                // 否则，将这段连续区间起始位置拼起来
                res.add(sb.append(nums[l]).append("->").append(nums[r]).toString());
            }
            l = r + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> res = new Solution().summaryRanges(nums);
        System.out.println(res);
    }
}

/**
 * 上面代码是对下面的优化，将拼接字符串替代为使用StringBuilder进行拼接。下面版本执行时间8ms，上面代码执行时间0ms
 */
class AnotherSolution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        List<String> res = new ArrayList<>();
        int l = 0; // 左指针初始化为0
        while (l < len) {
            int r = l;
            // 当值是连续的时候，持续移动右指针
            while (r + 1 < len && nums[r + 1] == nums[r] + 1) {
                r++;
            }
            if (l == r) {
                // l == r 可能代表到达边界
                res.add("" + nums[l]);
            } else {
                // 否则，将这段连续区间起始位置拼起来
                res.add("" + nums[l] + "->" + nums[r]);
            }
            l = r + 1;
        }
        return res;
    }
}
