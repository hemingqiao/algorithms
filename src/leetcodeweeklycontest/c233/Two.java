package src.leetcodeweeklycontest.c233;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/21 10:16:01
 * description:
 * 给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
 *
 * 订单类型 orderTypei 可以分为两种：
 *
 * 0 表示这是一批采购订单 buy
 * 1 表示这是一批销售订单 sell
 * 注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
 *
 * 存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
 *
 * 如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
 * 反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
 * 输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
 *
 * 提示：
 *
 * 1 <= orders.length <= 10^5
 * orders[i].length == 3
 * 1 <= pricei, amounti <= 10^9
 * orderTypei 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-orders-in-the-backlog
 *
 * 参考：https://leetcode-cn.com/problems/number-of-orders-in-the-backlog/solution/c-priority_queue-by-jesse-42-xdmt/
 */
public class Two {
    // 单纯模拟也并不容易
    public int getNumberOfBacklogOrders(int[][] orders) {
        int n = orders.length;
        int mod = (int) (1e9 + 7);
        // 积压的销售订单，小顶堆，堆顶是价格最低的销售订单
        PriorityQueue<int[]> sell = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 积压的采购订单，大顶堆，堆顶是价格最高的采购订单
        PriorityQueue<int[]> buy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int[] order = orders[i];
            if (order[2] == 0) { // 这是一批采购订单
                while (!sell.isEmpty() && order[1] > 0) {
                    int[] top = sell.poll();
                    if (top[0] <= order[0]) {
                        int num = Math.min(top[1], order[1]);
                        top[1] -= num;
                        order[1] -= num;
                        if (top[1] > 0) {
                            sell.offer(top);
                            break;
                        }
                    } else {
                        sell.offer(top);
                        break;
                    }
                }
                if (order[1] > 0) {
                    buy.offer(order);
                }
            } else { // 这是一批销售订单
                while (!buy.isEmpty() && order[1] > 0) {
                    int[] top = buy.poll();
                    if (order[0] <= top[0]) {
                        int num = Math.min(top[1], order[1]);
                        top[1] -= num;
                        order[1] -= num;
                        if (top[1] > 0) {
                            buy.offer(top);
                            break;
                        }
                    } else {
                        buy.offer(top);
                        break;
                    }
                }
                if (order[1] > 0) {
                    sell.offer(order);
                }
            }
        }
        int res = 0;
        while (!sell.isEmpty()) {
            int[] top = sell.poll();
            res = (res + top[1]) % mod;
        }
        while (!buy.isEmpty()) {
            int[] top = buy.poll();
            res = (res + top[1]) % mod;
        }
        return res;
    }
}
