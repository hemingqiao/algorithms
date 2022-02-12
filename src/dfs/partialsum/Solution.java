package src.dfs.partialsum;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 22:22:49
 * description:
 */
public class Solution {
    // 给定一个数组和一个整数k，判断是否可以从中选取出若干个数，使得它们的和恰好为k

    public boolean partialSum(int[] nums, int k) {
        return dfs(nums, k, 0, 0);
    }

    public boolean dfs(int[] nums, int k, int index, int sum) {
        if (index == nums.length) return sum == k;

        // 不加上第index个元素
        if (dfs(nums, k, index + 1, sum)) return true;

        // 加上第index个元素
        if (dfs(nums, k, index + 1, sum + nums[index])) return true;

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 2, 4, 7};
        int k = 13;
        boolean res = s.partialSum(test, k);
        System.out.println(res);
    }
}
