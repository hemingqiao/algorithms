package blogandquestion.algorithms.leetcodeweeklycontest.c220;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/20 10:28:31
 * description:
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 *
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-erasure-value
 *
 */
public class Solution {
//    public int maximumUniqueSubarray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int res = nums[0];
//        int temp = 0;
//        int l = 0, r = 1;
//        Set<Integer> record = new HashSet<>();
//        while (l < nums.length) {
//            if (l == nums.length - 1) {
//                res = Math.max(res, nums[l]);
//                break;
//            }
//            record.add(nums[l]);
//            temp += nums[l];
//            for (int i = l + 1; i < nums.length; i++) {
//                if (!record.contains(nums[i])) {
//                    temp += nums[i];
//                    record.add(nums[i]);
//                    if (i == nums.length - 1) {
//                        return Math.max(res, temp);
//                    }
//                } else {
//                    res = Math.max(res, temp);
//                    temp = 0;
//                    l = l + 1;
//                    record.clear();
//                    break;
//                }
//            }
//            res = Math.max(res, temp);
//        }
//        return res;
//    }

    // 参考：https://leetcode-cn.com/problems/maximum-erasure-value/solution/hua-dong-chuang-kou-shuang-bai-by-nian-z-8gfv/
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                sum += nums[i];
                set.add(nums[i]);
                max = Math.max(max, sum);
            } else {
                // 从left开始找到与nums[i]相等的位置，这个位置之前的元素也需要从滑动窗口中移除
                while (nums[left] != nums[i]) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                left++; // 上面while循环直到重复位置，++跳过这个重复位置
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{10000,1,10000,1,1,1,1,1,1};
        int res = s.maximumUniqueSubarray(test);
        System.out.println(res);
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/reformat-phone-number/comments/713544
 */
class ReformatNumber {
    public String reformatNumber(String s) {
        String str = s.replace(" ", "").replace("-", "");
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int index = 0;
        // len - 1 - index + 1 >= 5，剩余字符长度大于等于5时无需考虑其他情况
        while (len - index >= 5) {
            sb.append(str.substring(index, index + 3));
            sb.append("-");
            index += 3;
        }
        if (len - index == 4) { // 如果剩余四个字符
            sb.append(str.substring(index, index + 2));
            sb.append("-");
            sb.append(str.substring(index + 2, index + 4));
        } else { // 三个或者两个字符直接拼到最后面
            sb.append(str.substring(index, len));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReformatNumber rn = new ReformatNumber();
        String s = "1-23-45 6";
        String res = rn.reformatNumber(s);
        System.out.println(res);
    }
}
