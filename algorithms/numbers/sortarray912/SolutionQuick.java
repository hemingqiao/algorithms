package blogandquestion.algorithms.numbers.sortarray912;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 10:24:33
 * description: 选取序列的第一个元素作为基准的快速排序，在时间上击败93
 */
public class SolutionQuick {
    public int[] quickSort(int[] arr) {
        quickSortAuxiliary(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortAuxiliary(int[] arr, int low, int high) {
        if (low >= high) return; // base case
        int left = low, right = high;
        int pivot = arr[low];

        while (left < right) {
            // 从序列的右边开始找到第一个小于基准的元素
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 从序列的左边开始找到第一个大于基准的元素
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[left];
        arr[left] = pivot;

        quickSortAuxiliary(arr, low, left - 1);
        quickSortAuxiliary(arr, left + 1, high);
    }

    public static void main(String[] args) {
        SolutionQuick sq = new SolutionQuick();
        int[] test = {3, 2, 1, 1, 5, 8, 14, 64, 32, 1024, 512};
        int[] sorted = sq.quickSort(test);
        System.out.println(Arrays.toString(sorted));
    }
}
