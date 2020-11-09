package blogandquestion.algorithms.numbers.minsubarraylen209;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 20:30:31
 * description: 解题思路
 * see: https://mp.weixin.qq.com/s/UrZynlqi4QpyLlLhBPglyg
 */
public class BruteSolution {
    // 时间复杂度：O(n²)
    // 执行时间高达上百毫秒，聘美JavaScript的执行时间了😂
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) {
            sum = 0; // 每次外层循环时重置sum的值
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    subLength = j - i + 1; // 更新此时子序列的长度
                    result = Math.min(result, subLength);
                    // 因为是找符合条件的最短连续子序列，所以一旦找到一个就break内层循环，外层循环前进一位，继续查找是否有更短的符合条件的子序列
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，说明没有找到符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
