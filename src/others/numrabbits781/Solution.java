package src.others.numrabbits781;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/04 13:32:22
 * description:
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 *
 * 参考：https://leetcode-cn.com/problems/rabbits-in-forest/solution/1ms100onlognjie-ti-guan-jian-ru-he-li-jie-zui-shao/
 */
public class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        if (n == 0) return 0;
        Arrays.sort(answers);
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int temp = answers[i] + 1;
            ret += temp;
            int start = i;
            int origin = answers[i];
            while (start < n && answers[start++] == origin && temp > 0) {
                --temp;
                ++i;
            }
            --i;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{4, 0, 0, 2, 4};
        int res = s.numRabbits(test);
        System.out.println(res);
    }
}
