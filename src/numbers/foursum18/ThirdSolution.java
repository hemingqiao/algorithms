package src.numbers.foursum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 15:53:44
 * description:
 * 解题思路
 * see: https://mp.weixin.qq.com/s/nQrcco8AZJV1pAOVjeIU_g
 */
public class ThirdSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        // 对数组进行升序排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);

                        // 去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        // 去重完成后，左右指针收缩
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}

class Optimization {
    // 这个的时间效率很高了，时间击败99.95，空间击败96.79
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        // 对数组进行升序排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }
            int max1 = nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1];
            if (max1 < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) {
                    break;
                }
                int max2 = nums[i] + nums[j] + nums[length - 2] + nums[length - 1];
                if (max2 < target) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        // 使用下面简洁的写法执行时间反而变长了😂
                        // res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));

                        // 去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        // 去重完成后，左右指针收缩
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
