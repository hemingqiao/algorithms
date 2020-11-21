package blogandquestion.algorithms.array.topk.findkthlargest215;

import java.util.Random;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 11:25:54
 * description: 借助于快速排序。时间效率好上一些，击败30%
 * 解题思路
 * see: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-cherry-n1/
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 */
public class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, target);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getIndex(int[] nums, int low, int high) {
        int pivot = nums[low]; // 基准元素
        while (low < high) {
            // 从序列的右边找到第一个小于基准的元素
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            // 找到第一个小于基准的元素后，将其赋值给low
            nums[low] = nums[high];
            // 从序列的左边开始找到第一个大于基准的元素
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            // 找到第一个大于基准的元素后，将其赋值给high
            nums[high] = nums[low];
        }
        // 跳出循环时low == high，将pivot置于low处
        nums[low] = pivot;
        // 返回这个在序列中排好序的元素的位置
        return low;
    }

    public int getRandomIndex(int[] nums, int low, int high) {
        int r = random.nextInt(high - low + 1) + low;
        swap(nums, low, r); // 将随机获取的元素交换到序列头部
        return getIndex(nums, low, high); // 获取随机生成的元素在排好序的序列中的位置
    }

    public int quickSort(int[] nums, int low, int high, int target) {
        int index = getIndex(nums, low, high);
        if (index == target) return nums[index];
        return index < target ? quickSort(nums, index + 1, high, target) : quickSort(nums, low, index - 1, target);
    }
}
