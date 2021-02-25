package blogandquestion.algorithms.dp.lis.lengthoflis300;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/25 19:42:10
 * description:
 *
 * 三刷，这一题真是迷人
 * 参考：https://github.com/grandyang/leetcode/issues/300
 * 参考：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 * 参考：
 */
public class ExerciseSolution1 {
    /*
    来看一种动态规划 Dynamic Programming 的解法，这种解法的时间复杂度为 O(n2)，类似 brute force 的解法，维护一个一维 dp 数组，其中
    dp[i] 表示以 nums[i] 元素结尾的最长递增子串的长度，对于每一个 nums[i]，从第一个数再搜索到i，如果发现某个数小于 nums[i]，更新 dp[i]，
    更新方法为 dp[i] = max(dp[i], dp[j] + 1)，即比较当前 dp[i] 的值和那个小于 num[i] 的数的 dp 值加1的大小，就这样不断的更新 dp 数组，
    同时更新结果，数组遍历完后最大的值就是要返回的 LIS 的长度
     */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        // dp[i]的值表示长度为 i + 1 的所有上升子序列的结尾（尾部元素）的最小值
        int[] dp = new int[n];
        int size = 0; // size标识dp数组中元素个数
        for (int i = 0; i < n; i++) {
            // 二分搜索的右边界是dp数组的真实元素个数，注意是左闭右开的区间
            // 利用二分搜索在dp数组中查找第一个不小于当前元素的位置
            int left = 0, right = size;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (dp[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[left] = nums[i];
            if (left == size) size++; // 如果当前元素比dp数组中所有元素都大，那么二分搜索返回的位置是size
        }
        return size;
    }
}
