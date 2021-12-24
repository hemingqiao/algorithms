package blogandquestion.algorithms.array.singlenumber260;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/31 21:09:25
 * description:
 */
public class ExerciseSolution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) xor ^= nums[i];
        int k = 0;
        while ((xor >> k & 1) == 0) k++;
        return new int[]{get(nums, k, 0), get(nums, k, 1)};
    }

    public int get(int[] nums, int k, int t) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> k & 1) == t) res ^= nums[i];
        }
        return res;
    }
}
