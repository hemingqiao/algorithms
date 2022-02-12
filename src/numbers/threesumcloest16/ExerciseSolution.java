package src.numbers.threesumcloest16;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 09:42:17
 * description:
 */
public class ExerciseSolution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0, delta = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int fixed = nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int t = fixed + nums[left] + nums[right];
                int d = t - target;
                if ((t - target) > 0) {
                    if (d < delta) {
                        delta = d;
                        ret = t;
                    }
                    right--;
                } else if ((t - target) < 0) {
                    if (Math.abs(d) < delta) {
                        delta = Math.abs(d);
                        ret = t;
                    }
                    left++;
                } else {
                    return t;
                }
            }
        }
        return ret;
    }

    // 执行了一些去重，关键去重是利用双指针进行查找时，先比较最大值和最小值
    public int threeSumClosest1(int[] nums, int target) {
        int ret = 0, delta = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int fixed = nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int min = fixed + nums[left] + nums[left + 1]; // 最小值
                if (min > target) {
                    if (min - target < delta) {
                        delta = min - target;
                        ret = min;
                    }
                    break;
                }
                int max = fixed + nums[n - 2] + nums[n - 1];
                if (max < target) {
                    if (Math.abs(max - target) < delta) {
                        delta = Math.abs(max - target);
                        ret = max;
                    }
                    break;
                }
                int t = fixed + nums[left] + nums[right];
                int d = t - target;
                if ((t - target) > 0) {
                    if (d < delta) {
                        delta = d;
                        ret = t;
                    }
                    while (left < right && nums[right] == nums[right - 1]) right--; // nums[right]去重
                    right--;
                } else if ((t - target) < 0) {
                    if (Math.abs(d) < delta) {
                        delta = Math.abs(d);
                        ret = t;
                    }
                    while (left < right && nums[left] == nums[left + 1]) left++; // nums[left]去重
                    left++;
                } else {
                    return t;
                }
            }
            while (i < n - 2 && nums[i] == nums[i + 1]) i++; // nums[i]去重
        }
        return ret;
    }
}
