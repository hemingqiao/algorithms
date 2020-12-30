package blogandquestion.algorithms.backtrack.judgepoint24679;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/30 20:38:35
 * description:
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/24-game
 *
 * 参考：https://leetcode-cn.com/problems/24-game/solution/ying-gai-shi-man-hao-li-jie-de-si-lu-liao-by-xiao_/557157
 * 参考：https://leetcode-cn.com/problems/24-game/solution/ying-gai-shi-man-hao-li-jie-de-si-lu-liao-by-xiao_/
 * 参考：https://leetcode-cn.com/problems/24-game/solution/bi-guan-fang-jie-da-geng-hao-li-jie-de-da-an-you-d/
 */
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) list.add((double) num);
        return backtracking(list);
    }

    private boolean backtracking(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 1e-6;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> copy = new ArrayList<>(nums);
                // 注意，这里不能先移除i，在移除j，因为i小于j，先移除i在移除j会导致下标越界
                // 如[32, 64, 1024], i = 1, j = 2
                // 若是先移除i，list变为[32, 1024]，此时移除j(2)就会导致下标越界，因此应先移除下标大的，再移除小的
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid |= backtracking(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= backtracking(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= backtracking(copy);
                copy.set(copy.size() - 1, a / b);
                valid |= backtracking(copy);
                copy.set(copy.size() - 1, b - a); // 只有相减和相除这两种操作互换操作数结果可能不同（a和b互换），所以还需要验证a和b互换
                valid |= backtracking(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= backtracking(copy);
                if (valid) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 验证list
        List<Integer> test = new ArrayList<>();
        test.add(32);
        test.add(1024);
        test.add(64);
        test.remove(test.size() - 2);
        System.out.println(test);
    }
}
