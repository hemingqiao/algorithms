package blogandquestion.algorithms.array.firstmissingpositive41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/22 20:47:06
 * description:
 */
public class ExerciseSolution {
    // 利用了现成的数据结构，同时也不满足O(n)的时间复杂度的要求
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>(); // set去重
        for (int num : nums) set.add(num);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : set) {
            if (i > 0) queue.add(i);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            if (queue.poll() == count) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // 直接利用Set（时间复杂度O(n)，但是空间复杂度达不到要求）
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!binarySearch(nums, i)) return i;
        }
        return n + 1;
    }

    public boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // 时间复杂度O(n)，空间复杂度O(1)，就是不是太好理解
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) return i;
        }
        return n + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
