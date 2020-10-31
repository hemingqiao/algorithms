package blogandquestion.algorithms.numbers.sortarray912;

import java.util.Random;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 10:32:14
 * description:
 */
public class SolutionRandomQuick {
    public int[] randomQuickSort(int[] arr) {
        randomQuickSortAuxiliary(arr, 0, arr.length - 1);
        return arr;
    }

    private void randomQuickSortAuxiliary(int[] arr, int low, int high) {
        if (low >= high) return; // base case
        int pivotIndex = (int) (Math.floor(Math.random() * (high - low + 1)) + low);
        // int pivotIndex = new Random().nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, high); // 将基准元素交换到序列的最后面

        int i = low - 1;
        for (int j = low; j < high; j++) { // j取不到索引high是因为基准元素此时位于索引high处
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, high); // 将基准元素换回序列中合适的位置

        randomQuickSortAuxiliary(arr, low, i - 1);
        randomQuickSortAuxiliary(arr, i + 1, high);
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        SolutionRandomQuick srq = new SolutionRandomQuick();
        int[] test = {3, 2, 1, 1, 5, 8, 14, 64, 32, 1024, 512};
        int[] sorted = srq.randomQuickSort(test);
        System.out.println(sorted);
    }
}
