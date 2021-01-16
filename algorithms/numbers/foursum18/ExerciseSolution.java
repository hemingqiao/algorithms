package blogandquestion.algorithms.numbers.foursum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 21:12:18
 * description:
 */
public class ExerciseSolution {
    // 朴素的暴力解法，时间复杂度O(n^4)
    // 要注意的点：在每层循环内，只有大于起始索引时，才能进行去重，否则会将小于起始索引的值给排除掉（会将上一层的相同大小的值排除）
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums); // 排序以方便去重
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < n - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    for (int m = k + 1; m < n; m++) {
                        if (m > k + 1 && nums[m] == nums[m - 1]) continue;
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[i]);
                            t.add(nums[j]);
                            t.add(nums[k]);
                            t.add(nums[m]);
                            list.add(t);
                        }
                    }
                }
            }
        }
        return list;
    }

    // 与三数之和类似，可以固定两个数，然后利用数组已排序的性质，将查找最后两个数的时间复杂度降为O(n)，总时间复杂度降为O(n^3)
    // 二刷，竟然可以独立写出来击败100%的解法了，难道是我变强了（不是，大雾）
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int fixed1 = nums[i];
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int fixed2 = nums[j];
                if (fixed1 + fixed2 + nums[j + 1] + nums[j + 2] > target) continue; // 循环内的最小值
                if (fixed1 + fixed2 + nums[n - 2] + nums[n - 1] < target) continue; // 循环内的最大值
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int t = fixed1 + fixed2 + nums[left] + nums[right];
                    if (t < target) {
                        left++;
                    } else if (t > target) {
                        right--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(fixed1);
                        temp.add(fixed2);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        list.add(temp);
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
