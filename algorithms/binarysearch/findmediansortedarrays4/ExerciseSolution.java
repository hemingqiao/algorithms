package blogandquestion.algorithms.binarysearch.findmediansortedarrays4;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/25 22:58:11
 * description:
 */
public class ExerciseSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, l = (m + n + 1) >> 1, r = (m + n + 2) >> 1;
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    // 找到两个有序数组中的第 k 个元素，k 从 1 开始
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1]; // nums1为空数组，所有就是在nums2中找第k个元素，下标为k - 1
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]); // k为1，则取两个数组第一个元素的较小值
        int ml1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int ml2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (ml1 < ml2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
