package blogandquestion.algorithms.array.findkthlargest215;

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
        // 由于存在极端情况（数组已经有序），所以在选取基准元素时最好在序列中随机选取
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

/**
 * 在选取基准元素时改变了策略，在序列中随机选取一个元素作为基准，时间比上面快乐10ms，从击败25到99.6
 */
class AnotherSolutionOpt {
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
        // 由于存在极端情况（数组已经有序），所以在选取基准元素时最好在序列中随机选取
        int random = (int) (Math.random() * (high - low + 1)) + low;
        swap(nums, low, random);
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
