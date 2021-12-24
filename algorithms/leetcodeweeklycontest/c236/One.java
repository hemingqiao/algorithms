package blogandquestion.algorithms.leetcodeweeklycontest.c236;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/11 10:15:40
 * description:
 */
public class One {
    public int arraySign(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) sum += nums[i];
        return sum > 0 ? 1 : sum < 0 ? -1 : 0;
    }
}
