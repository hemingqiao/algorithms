package src.topk.findkthlargest215;

import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/02 14:39:32
 * description:
 */
public class ExerciseSolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            queue.offer(nums[i]);
            // 需要保证将第三个元素加入堆中进行排序后，再弹出堆顶元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int res = es.findKthLargest1(test, k);
        System.out.println(res);
    }

    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = quickFind(nums, left, right);
            if (mid == targetIndex) {
                return nums[mid];
            } else if (mid < targetIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int quickFind(int[] nums, int low, int high) {
        swap(nums, low, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = nums[low];
        int j = low;
        for (int i = j + 1; i <= high; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, low, j);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
