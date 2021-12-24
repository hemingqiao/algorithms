package blogandquestion.algorithms.array.merge88;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/05 21:14:13
 * description:
 */
public class ExerciseSolution1 {
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
        int p = m + n - 1;
        int i = m - 1;
        // 只要nums2中仍然存在元素，就循环下去
        while (n-- > 0) {
            int temp = nums2[n];
            while (i >= 0 && nums1[i] > temp) nums1[p--] = nums1[i--];
            nums1[p--] = temp;
        }
    }

    public static void main(String[] args) {
        ExerciseSolution1 e = new ExerciseSolution1();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;
        e.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(new int[0]));
    }
}
