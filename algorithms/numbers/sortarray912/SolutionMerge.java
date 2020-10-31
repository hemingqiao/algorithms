package blogandquestion.algorithms.numbers.sortarray912;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 10:01:47
 * description: 归并排序，在时间上击败55
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 *
 */
public class SolutionMerge {
    public int[] mergeSort(int[] arr) {
        mergeSortAuxiliary(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSortAuxiliary(int[] arr, int start, int end) {
        if (start >= end) return; // base case
        int mid = (start + end) / 2;
        mergeSortAuxiliary(arr, start, mid);
        mergeSortAuxiliary(arr, mid + 1, end);
        merge(arr, start, mid, end); // 归并两个序列
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[k++] = arr[p2++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 1, 5, 8, 14, 64, 32, 1024, 512};
        SolutionMerge sm = new SolutionMerge();
        int[] sorted = sm.mergeSort(test);
        System.out.println(Arrays.toString(sorted));
    }
}
