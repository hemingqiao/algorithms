package src.array.findlengthoflcis674;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/24 09:26:30
 * description:
 */
public class ExerciseSolution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int count = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,7};
        ExerciseSolution es = new ExerciseSolution();
        int res = es.findLengthOfLCIS(test);
        System.out.println(res);
    }
}
