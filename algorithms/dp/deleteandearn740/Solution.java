package blogandquestion.algorithms.dp.deleteandearn740;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/05 18:34:39
 * description:
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 
 * nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10003];
        int n = nums.length;
        for (int i = 0; i < n; i++) sum[nums[i]] += nums[i];
        int take = 0; // take表示拿当前数字的积分
        int skip = 0; // skip表示不拿当前数字的积分
        for (int i = 0; i < 10003; i++) {
            int takei = skip + sum[i]; // 拿了当前的数字，前一个数字就不能拿（即必须由skip转移而来）
            int skipi = Math.max(skip, take); // 而不拿当前的数字可以由两种情况转移而来：前一个数字不拿，前一个数字拿，当前数字不拿
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
