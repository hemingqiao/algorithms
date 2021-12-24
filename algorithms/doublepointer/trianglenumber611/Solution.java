package blogandquestion.algorithms.doublepointer.trianglenumber611;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/04 21:00:39
 * description:
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1, k = 0; j > 0 && k < j; j--) {
                // nums[k] + nums[j] > nums[i]的最小的k
                while (k < j && nums[k] <= nums[i] - nums[j]) k++;
                res += j - k; // j - 1 - k + 1
            }
        }
        return res;
    }
}
