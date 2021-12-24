package blogandquestion.algorithms.binarysearch.findmediansortedarrays4;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/03 22:58:05
 * description:
 */
public class ExerciseSolution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, total / 2);
            int right = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    // nums1从i开始，nums2从j开始，找到第k个数(注意，k是从1开始的)
    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k); // 始终令nums1中的元素较少
        }
        if (k == 1) { // 边界
            // 如果元素较少的数组已经找完了
            if (nums1.length == i) return nums2[j];
            else return Math.min(nums1[i], nums2[j]);
        }
        if (nums1.length == i) return nums2[j + k - 1];
        // nums1中的元素始终较少，所以nums1可能越界
        int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) return find(nums1, i, nums2, sj, k - (sj - j));
        else return find(nums1, si, nums2, j, k - (si - i));
    }
}
