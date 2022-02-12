package src.topk.findkthlargest215;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 11:14:54
 * description: 时间效率非常低。
 */
public class MySolution {
    public int findKthLargest(int[] nums, int k) {
        nums = quickSort(nums);
        int i = nums.length - 1;
        while (k > 1) {
            i--;
            k--;
        }
        return nums[i];
    }

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
}
