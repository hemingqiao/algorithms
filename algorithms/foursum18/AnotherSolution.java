package blogandquestion.algorithms.foursum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 18:32:25
 * description:
 *
 * see: https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/215955
 */
public class AnotherSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //计算当前的最小值，如果最小值都比target大，不用再继续计算了
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                continue;
            }
            //计算当前最大值，如果最大值都比target小，不用再继续计算了
            int max = nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1];
            if (max < target) {
                continue;
            }
            //选择第二个数字
            for (int j = i + 1; j < len - 2; j++) {
                //相邻元素重复，会产生重复结果
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //计算当前的最小值，如果最小值都比target大，不用再继续计算了
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target) {
                    continue;
                }
                //计算当前最大值，如果最大值都比target小，不用再继续计算了
                max = nums[i] + nums[j] + nums[len - 2] + nums[len - 1];
                if (max < target) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
