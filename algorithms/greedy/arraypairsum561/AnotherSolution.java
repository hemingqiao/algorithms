package blogandquestion.algorithms.greedy.arraypairsum561;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/16 09:28:41
 * description:
 */
public class AnotherSolution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        int ret = 0;
        quickSort(nums, 0, n - 1);
        for (int i = 0; i < n; i += 2) {
            ret += nums[i];
        }
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
}
