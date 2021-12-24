package blogandquestion.algorithms.array.maximumproduct628;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 15:33:50
 * description: 和414题类似，求数组中最大的几个数。
 */
public class ExerciseSolution {
    // 需要注意的地方：数组中存在负数
    public int maximumProduct(int[] nums) {
        int last1 = Integer.MAX_VALUE, last2 = Integer.MAX_VALUE;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t > third) {
                if (t > first) {
                    third = second;
                    second = first;
                    first = t;
                } else if (t > second) {
                    third = second;
                    second = t;
                } else {
                    third = t;
                }
            }
            if (t < last2) {
                if (t < last1) {
                    last2 = last1;
                    last1 = t;
                } else {
                    last2 = t;
                }
            }
        }
        return Math.max(last1 * last2 * first, first * second * third);
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{-1, -2, -3};
        int res = es.maximumProduct(test);
        System.out.println(res);
    }
}
