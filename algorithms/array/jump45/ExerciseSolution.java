package blogandquestion.algorithms.array.jump45;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 13:23:27
 * description:
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
            start = end + 1; // 在走完count步之后，至少到达的坐标（在上一次到达的最远坐标的基础上走最短的步数：向前走一步）
            end = maxLength; // 走完count步之后，能够到达的最远的坐标
        }
        return count;
    }

    public int jump1(int[] nums) {
        int n = nums.length;
        int count = 0;
        int start = 0, end = 0;
        int cover = 0;
        while (end < n - 1) {
            for (int i = start; i <= end; i++) {
                cover = Math.max(cover, i + nums[i]);
            }
            ++count;
            start = end + 1; // 跳完count步之后，至少能够到达的坐标，如对于初始情形，跳完第一步之后至少能够到达索引1处
            end = cover; // 对于初始情形，跳完第一步之后最远能够到达cover（2）处
        }
        return count;
    }
}
