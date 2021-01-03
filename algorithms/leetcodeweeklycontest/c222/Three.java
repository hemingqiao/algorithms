package blogandquestion.algorithms.leetcodeweeklycontest.c222;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/03 14:13:46
 * description:
 * 我们称一个分割整数数组的方案是 好的 ，当它满足：
 *
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
 * 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1]
 * 输出：1
 * 解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,2,5,0]
 * 输出：3
 * 解释：nums 总共有 3 种好的分割方案：
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * 示例 3：
 *
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：没有好的分割方案。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays
 *
 * 参考：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays/solution/qian-zhui-he-by-ling-ling-zhu-qi-9clu/
 */
public class Three {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        // 计算前缀和
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int pre = 0; // 定义两个指针pre和cur模拟分割过程
        int cur = 0;
        long res = 0; // res很大，可能会超过整型的范围
        for (int i = 0; i < n - 2; i++) {
            pre = Math.max(pre, i + 1);
            while (pre < n - 1 && sum[pre + 1] - sum[i + 1] < sum[i + 1]) {
                pre++;
            }
            if (pre == n - 1) break;
            cur = Math.max(pre, cur);
            while (cur < n - 1 && sum[n] - sum[cur + 1] >= sum[cur + 1] - sum[i + 1]) {
                cur++;
            }
            res += cur - pre;
        }
        return (int) (res % (1e9 + 7));
    }
}
