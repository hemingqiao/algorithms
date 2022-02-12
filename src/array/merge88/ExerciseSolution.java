package src.array.merge88;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/29 13:42:02
 * description:
 */
public class ExerciseSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int end = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[end--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[end--] = nums2[j--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int i = m - 1;
        while (n-- > 0) {
            int t = nums2[n];
            while (i >= 0 && nums1[i] > t) {
                nums1[end--] = nums1[t--];
            }
            nums1[end--] = t;
        }
    }

    // 有点丑这代码
    // lcci面试题，https://leetcode-cn.com/problems/sorted-merge-lcci/
    public void merge2(int[] A, int m, int[] B, int n) {
        int p = m + n - 1;
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
            int a = A[i], b = B[j];
            if (a >= b) {
                A[p--] = a;
                i--;
            } else {
                A[p--] = b;
                j--;
            }
        }
        while (j >= 0) {
            A[p--] = B[j--];
        }
    }

    public void merge3(int[] A, int m, int[] B, int n) {
        int p = m + n - 1;
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
            A[p--] = A[i] >= B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[p--] = B[j--];
        }
    }
}
