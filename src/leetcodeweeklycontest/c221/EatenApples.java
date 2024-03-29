package src.leetcodeweeklycontest.c221;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/27 16:17:39
 * description:
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，
 * 第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 *
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 *  
 *
 * 提示：
 *
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 *
 * 参考：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/solution/you-xian-dui-lie-you-xian-chi-zui-zao-gu-3ti9/
 */
public class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        // 优先队列，队首是最早过期的，int[0]存储苹果个数，int[1]存储过期时间
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int eaten = 0;
        for (int i = 0; i < apples.length || queue.size() > 0; i++) {
            // 首先移除过期的苹果
            while (!queue.isEmpty()) {
                int[] apple = queue.peek();
                if (apple[1] <= i) {
                    queue.poll();
                } else {
                    break;
                }
            }
            // 向队列中添加当天（第i天）新长出来的苹果
            if (i < apples.length && apples[i] > 0) {
                queue.add(new int[]{apples[i], i + days[i]});
            }
            // 优先吃一个会最早过期的苹果（队列头部）
            int[] apple = queue.peek();
            if (apple != null && apple[0] > 0) {
                eaten++;
                apple[0]--;
                if (apple[0] == 0) {
                    // 如果吃过之后，苹果数为0，从队列中弹出
                    queue.poll();
                }
            }
        }
        return eaten;
    }
}
