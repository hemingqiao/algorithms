package blogandquestion.algorithms.topk.findkthlargest215n;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 17:24:21
 * description:
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        // 区间长度小于等于1时，就不需要进行递归排序了
        if (low >= high) return;
        swap(arr, low, (int)(Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
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
        // 执行完上面的循环后，left == right，并且[low + 1, left]区间内的元素都小于等于pivot，(left, high]区间内的元素都大于pivot
        // 所以下面执行交换，将pivot元素换到left处
        // 执行完交换之后，[low, left - 1]区间内的元素都小于等于pivot，left处元素值等于pivot，(left, high]区间内的元素值大于pivot
        arr[low] = arr[left];
        arr[left] = pivot;

        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] generateArray(int nums, int boundary) {
        int[] res = new int[nums];
        for (int i = 0; i < nums; i++) {
            int random = (int) (Math.random() * boundary);
            res[i] = random;
        }
        return res;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] test = q.generateArray(1500000, 10000000);
        //System.out.println(Arrays.toString(test));
        double now = System.currentTimeMillis();
        q.quickSort(test);
        System.out.println(System.currentTimeMillis() - now + "ms elapsed"); // 245.0ms elapsed
        //System.out.println(Arrays.toString(test));
    }
}

/**
 * 另一种形式的快排
 * 参考：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
class AnotherQuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        // 区间长度小于等于1时，就不需要进行递归排序了
        if (low >= high) return;
        swap(arr, low, (int)(Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        // 执行完上面这个循环之后，有[low + 1, j]区间内元素都小于pivot，(j, high]区间内元素大于等于pivot
        // 此时可以把pivot元素（位于索引low处）交换到索引 j 处，也就是 swap(arr, low, j);
        // 交换之后，有[low, j - 1]区间内元素都小于pivot，j处元素值等于pivot，(j, high]区间内元素大于等于pivot
        swap(arr, low, j);

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] generateArray(int nums, int boundary) {
        int[] res = new int[nums];
        for (int i = 0; i < nums; i++) {
            int random = (int) (Math.random() * boundary);
            res[i] = random;
        }
        return res;
    }

    public static void main(String[] args) {
        AnotherQuickSort q = new AnotherQuickSort();
        int[] test = q.generateArray(1500000, 10000000);
        //System.out.println(Arrays.toString(test));
        double now = System.currentTimeMillis();
        q.quickSort(test);
        System.out.println(System.currentTimeMillis() - now + "ms elapsed"); // 209.0ms elapsed
        //System.out.println(Arrays.toString(test));
    }
}

class ThirdQuickSort {
    public void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2]; // 这种快排取序列中点作为基准，所以退出while循环后不需要再执行交换操作
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, left, end);
        quickSort(A, start, right);
    }

    public static void main(String[] args) {
        AnotherQuickSort q = new AnotherQuickSort();
        int[] test = q.generateArray(1500000, 10000000);
        //System.out.println(Arrays.toString(test));
        ThirdQuickSort ts = new ThirdQuickSort();
        double now = System.currentTimeMillis();
        ts.quickSort(test);
        System.out.println(System.currentTimeMillis() - now + "ms elapsed"); // 236.0ms elapsed
        //System.out.println(Arrays.toString(test));
    }
}
