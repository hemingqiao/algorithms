package blogandquestion.algorithms.topk.findkthlargest215n;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 15:25:58
 * description:
 */
public class Solution {
    // 使用小顶堆
    // 关于小顶堆，参考：https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.peek();
    }
}

class AnotherSolution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int targetIndex = nums.length - k;
        while (left < right) {
            int mid = findIndex(nums, left, right);
            if (mid == targetIndex) {
                return nums[mid];
            } else if (mid < targetIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    private int findIndex(int[] arr, int low, int high) {
        int left = low, right = high;
        // 为了应对极端情况（如数组已经有序），避免快速排序退化
        // 在序列中随机选取一个元素作为快排的基准元素
        swap(arr, left, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = arr[left];
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
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
