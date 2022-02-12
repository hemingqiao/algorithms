package src.topk.getleastnumbersoffer40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/15 14:33:16
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) queue.poll();
        }
        int[] ret = new int[k];
        while (k-- > 0) {
            ret[k] = queue.poll();
        }
        return ret;
    }

    // use native sort
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] ret = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) ret[i] = arr[i];
        return ret;
    }

    // use quick sort
    public int[] getLeaseNumbers2(int[] arr, int k) {
        int[] ret = new int[k];
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) ret[i] = arr[i];
        return ret;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        swap(arr, low, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) swap(arr, ++j, i);
        }
        swap(arr, low, j);

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{0,0,1,2,4,2,2,3,1,4};
        es.quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        int n = arr.length;
        if (k == 0 || n == 0) return new int[0];
        return quickSelect(arr, 0, n - 1, k);
    }

    // 找到k所处的位置，此时索引k左边的值都小于右边的值
    public int[] quickSelect(int[] arr, int low, int high, int k) {
        int j = partition(arr, low, high);
        if (j == k) {
            int[] ret = new int[k];
            for (int i = 0; i < k; i++) ret[i] = arr[i];
            return ret;
        }
        return j > k ? quickSelect(arr, low, j - 1, k) : quickSelect(arr, j + 1, high, k);
    }

    public int partition(int[] arr, int low, int high) {
        if (low >= high) return low;
        swap(arr, low, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) swap(arr, ++j, i);
        }
        swap(arr, low, j);
        return j;
    }
}
