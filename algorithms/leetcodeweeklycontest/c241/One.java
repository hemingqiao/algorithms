package blogandquestion.algorithms.leetcodeweeklycontest.c241;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/16 20:40:47
 * description:
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 *
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 *
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 *
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3]
 * 输出：6
 * 解释：[1,3] 共有 4 个子集：
 * - 空子集的异或总和是 0 。
 * - [1] 的异或总和为 1 。
 * - [3] 的异或总和为 3 。
 * - [1,3] 的异或总和为 1 XOR 3 = 2 。
 * 0 + 1 + 3 + 2 = 6
 * 示例 2：
 *
 * 输入：nums = [5,1,6]
 * 输出：28
 * 解释：[5,1,6] 共有 8 个子集：
 * - 空子集的异或总和是 0 。
 * - [5] 的异或总和为 5 。
 * - [1] 的异或总和为 1 。
 * - [6] 的异或总和为 6 。
 * - [5,1] 的异或总和为 5 XOR 1 = 4 。
 * - [5,6] 的异或总和为 5 XOR 6 = 3 。
 * - [1,6] 的异或总和为 1 XOR 6 = 7 。
 * - [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
 * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 * 示例 3：
 *
 * 输入：nums = [3,4,5,6,7,8]
 * 输出：480
 * 解释：每个子集的全部异或总和值之和为 480 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 12
 * 1 <= nums[i] <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals
 *
 */
public class One {
    int ans = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> list, int p) {
        ans += getXorSum(list);
        if (p >= nums.length) return;
        for (int i = p; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int getXorSum(List<Integer> list) {
        int res = 0;
        for (int i : list) res ^= i;
        return res;
    }
}

class AnotherSolution {
    int ans = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int p, int xorSum) {
        if (p >= nums.length) {
            ans += xorSum;
            return;
        }
        dfs(nums, p + 1, xorSum);
        dfs(nums, p + 1, xorSum ^ nums[p]);
    }


    // for test
    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int[] test = {1, 3};
        int res = as.subsetXORSum(test);
        System.out.println(res);
    }
}
