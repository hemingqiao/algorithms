package blogandquestion.algorithms.numbers.findkthlargest215;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/06 16:50:50
 * description: 同快速排序类似，这里使用的是快速选择算法
 */
public class AnotherSolution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;
        while (left < right) {
            int mid = findIndex(nums, left, right);
            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    // 快速选择只需要找到index，不需要对左右两边进行排序
    private int findIndex(int[] nums, int low, int high) {
        int left = low, right = high;
        int pivot = nums[low];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        nums[low] = nums[left];
        nums[left] = pivot;
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
