package blogandquestion.algorithms.array.findrelativeranks506;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 16:00:02
 * description:
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 *
 */
public class Solution {
    // 利用大顶堆求解
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new Pair(nums[i], i));
        }
        String[] ret = new String[nums.length];
        int i = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            switch (i) {
                case 1:
                    ret[p.index] = "Gold Medal";
                    break;
                case 2:
                    ret[p.index] = "Silver Medal";
                    break;
                case 3:
                    ret[p.index] = "Bronze Medal";
                    break;
                default:
                    ret[p.index] = String.valueOf(i);
            }
            i++;
        }
        return ret;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{4, 5, 3, 2, 1};
        String[] res = s.findRelativeRanks(test);
        System.out.println(Arrays.toString(res));
    }

}
