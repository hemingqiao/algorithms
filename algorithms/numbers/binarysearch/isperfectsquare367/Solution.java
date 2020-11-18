package blogandquestion.algorithms.numbers.binarysearch.isperfectsquare367;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 19:11:05
 * description:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 *
 * 参考了mySqrt69的解法，稍微改动了一下
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)mid * mid <= num) { // 避免整型溢出
                // 寻找使得 k^2 <= num的最大k值
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer * answer == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(8));
    }
}
