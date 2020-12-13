package blogandquestion.algorithms.array.prefixsum.subarraysum560;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 19:16:03
 * description:
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        // 填充前序和数组
        // prefixSum[k] 表示元素 nums[0..k) 之和
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res = 0;
        // 穷举所有数组，判断其和是否等于k
        // sum of nums[i..j) = sum of nums[0..j) - sum of nums[0..i)
        // 可以取到len，因为prefixSum[len]代表nums[0,..len)之和
        for (int i = 0; i <= len; i++) {
            // 下标要向右偏移一位，因为prefixSum数组本身多了一个0在数组首部
            // 例如，利用prefix数组求第一个元素的值时，此时i = 0，需要用prefix[1] - prefix[0]才能得到
            for (int j = i + 1; j <= len; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
