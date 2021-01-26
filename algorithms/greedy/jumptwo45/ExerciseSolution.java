package blogandquestion.algorithms.greedy.jumptwo45;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/26 14:18:45
 * description:
 * 参考：https://leetcode-cn.com/problems/jump-game-ii/solution/liang-chong-bi-jiao-hao-li-jie-de-si-lu-c9br3/
 */
public class ExerciseSolution {
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int start = 0, end = 0; // 搜索范围
        int maxLength = 0;
        while (end < n - 1) {
            for (int i = start; i <= end; i++) {
                maxLength = Math.max(maxLength, i + nums[i]);
            }
            count++;
            start = end + 1; // 在走完count步之后，至少到达的坐标（在上一次到达的最远坐标的基础上走最短的步数：即向前走一步）
            end = maxLength; // 走完count步之后，能够到达的最远的坐标
        }
        return count;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{2, 3, 1, 1, 4, 5};
        int res = es.jump(test);
        System.out.println(res);
    }
}
