package blogandquestion.algorithms.dp.maxsubarray53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 20:33:22
 * description:
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次循环都比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
 *
 * see: https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
 */
public class AnotherSolution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {-2, -3, -4};
        int res = new Solution().maxSubArray(test);
        System.out.println(res);
    }
}
