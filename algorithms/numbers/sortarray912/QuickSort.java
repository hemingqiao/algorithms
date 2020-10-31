package blogandquestion.algorithms.numbers.sortarray912;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 11:46:43
 * description: 从这道题的时间效率来看，随机选取一个元素作为基准的执行时间都是要慢于直接取序列的第一个元素作为基准。无论是随机取元素
 * 后将基准元素换到序列头部还是换到序列尾部再进行排序。
 * 但是从随机的大数据来看，随机选取元素作为基准要稍快一些，如下面测试了对边界为15000000，数据量为10000000的随机数组进行排序。随机选取
 * 元素作为基准快了几十毫秒。
 */
public class QuickSort {
    Random random = new Random();

    public int[] quickSort(int[] arr) {
        quickSortAuxiliary(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSortAuxiliary(int[] arr, int low, int high) {
        if (low >= high) return; // base case
        // 在序列中随机取一个元素作为基准
        int pivotIndex = random.nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];

        swap(arr, low, pivotIndex); // 将基准元素换到序列头部

        int left = low, right = high;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        arr[low] = arr[left];
        arr[left] = pivot;

        quickSortAuxiliary(arr, low, left - 1);
        quickSortAuxiliary(arr, left + 1, high);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] test = {3, 2, 1, 1, 5, 8, 14, 64, 32, 1024, 512};
        int[] sorted = qs.quickSort(test);
        System.out.println(Arrays.toString(sorted));

        int[] big = qs.generateArr(15000000, 10000000);
        System.out.println(Arrays.toString(big));
        long now = System.currentTimeMillis();
        qs.quickSort(big);
        long time = System.currentTimeMillis() - now;
        System.out.println(Arrays.toString(big));


        SolutionQuick sq = new SolutionQuick();
        int[] big1 = qs.generateArr(15000000, 10000000);
        long now1 = System.currentTimeMillis();
        sq.quickSort(big1);
        long time1 = System.currentTimeMillis() - now1;
        System.out.println(Arrays.toString(big1));
        System.out.println(time + "ms elapsed"); // 1428ms elapsed
        System.out.println(time1 + "ms elapsed"); // 1485ms elapsed
    }

    private int[] generateArr(int boundary, int nums) {
        Random random = new Random();
        int[] result = new int[nums];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(boundary);
        }
        return result;
    }
}
