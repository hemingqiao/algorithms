package blogandquestion.algorithms.doublepointer.maxsatisfied1052;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/23 09:57:45
 * description:
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 *
 * 提示：
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 *
 */
public class Solution {
    // 暴力解法，能通过竟然
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) total += customers[i];
        }
        int other = 0;
        for (int j = 0; j + X <= n; j++) {
            int temp = 0;
            int cnt = 0;
            while (cnt < X) {
                if (grumpy[j + cnt] == 1) temp += customers[j + cnt];
                cnt++;
            }
            other = Math.max(other, temp);
        }
        return total + other;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
                customers[i] = 0;
            }
        }
        int left = 0;
        int other = 0;
        int temp = 0;
        for (int j = 0; j < n; j++) {
            temp += customers[j];
            if (j - left + 1 > X) {
                temp -= customers[left++];
            }
            other = Math.max(other, temp);
        }
        return total + other;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
                customers[i] = 0;
            }
        }
        int j = 0;
        int other = 0, temp = 0;
        while (j < n) {
            temp += customers[j];
            if (j >= X - 1) {
                if (temp > other) {
                    other = temp;
                }
                temp -= customers[j - (X - 1)];
            }
            j++;
        }
        return total + other;
    }
}
