package src.array.reversepairslcof51;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/23 19:33:14
 * description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 *
 * 参考：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 * 参考：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/java-gui-bing-pai-xu-tong-su-yi-dong-by-rwmfl/
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) >>> 1;
        return reversePairs(nums, low, mid) + reversePairs(nums, mid + 1, high) + merge(nums, low, mid, high);
    }

    public int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int cnt = 0;
        int p1 = left, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] > nums[p2]) cnt += mid - p1 + 1;
            temp[k++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            temp[k++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[k++] = nums[p2++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
        return cnt;
    }

    // brute solution
    // TLE
    public int reversePairs1(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int fixed = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (fixed > nums[j]) cnt++;
            }
        }
        return cnt;
    }
}
