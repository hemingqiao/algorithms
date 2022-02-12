package src.array.countsmaller315;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 21:04:35
 * description: 暂时性放弃
 */
public class Solution {
    // 超时
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < tar) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}
