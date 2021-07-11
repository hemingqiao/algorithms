package blogandquestion.algorithms.array.majorityelement229;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/11 08:32:35
 * description:
 */
public class ExerciseSolution {
    // https://www.acwing.com/video/1612/
    public List<Integer> majorityElement(int[] nums) {
        int r1 = -1, r2 = -1, c1 = 0, c2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (c1 > 0 && nums[i] == r1) {
                ++c1;
            } else if (c2 > 0 && nums[i] == r2) {
                ++c2;
            } else if (c1 == 0) {
                r1 = nums[i];
                ++c1;
            } else if (c2 == 0) {
                r2 = nums[i];
                ++c2;
            } else {
                // 如果当前值和两个仓库c1、c2中的值都不同，需要 `陪葬` 两个仓库中的一个值共两个数
                --c1;
                --c2;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == r1) ++c1;
            else if (nums[i] == r2) ++c2;
        }
        List<Integer> ret = new ArrayList<>();
        if (c1 > n / 3) ret.add(r1);
        if (c2 > n / 3) ret.add(r2);
        return ret;
    }
}
