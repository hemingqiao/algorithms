package blogandquestion.algorithms.numbers.checkperfectnumber507;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 14:24:14
 * description:
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 *  
 *
 * 示例 1：
 *
 * 输入：28
 * 输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 *
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 *
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 *
 * 输入：num = 8128
 * 输出：true
 * 示例 5：
 *
 * 输入：num = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 *
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        // 特判
        if (num == 1) return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                // 当num % i == 0 && i * i == num时，num是一个完全平方数，此时只需要加一个i
                if (i == 1 || i * i == num) {
                    sum += i;
                } else {
                    sum += i + num / i;
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int i = 1; i < 1000; i++) {
            if (s.checkPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
