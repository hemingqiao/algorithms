package src.array.merge88;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 11:19:56
 * description:
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[idx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // 退出循环后，如果i >= 0，就无需考虑了，因为就是要将nums2中的元素合并到nums1中，i >= 0表明2中的元素已经全部合并到1中了
        while (j >= 0) nums1[idx--] = nums2[j--];
    }
}
