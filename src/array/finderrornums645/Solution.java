package src.array.finderrornums645;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 11:29:52
 * description:
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个
 * 数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 *
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] record = new int[n + 1];
        for (int i = 0; i < n; i++) {
            record[nums[i]]++;
        }
        int[] ret = new int[2];
        for (int i = 1; i < n + 1; i++) {
            int times = record[i];
            if (times == 0) ret[1] = i;
            if (times == 2) ret[0] = i;
        }
        return ret;
    }
}
