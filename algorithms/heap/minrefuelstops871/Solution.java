package blogandquestion.algorithms.heap.minrefuelstops871;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/27 16:36:17
 * description:
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有station[i][1]升汽油。
 *
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 *
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：我们可以在不加油的情况下到达目的地。
 * 示例 2：
 *
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：我们无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 *
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 *  
 *
 * 提示：
 *
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-refueling-stops
 *
 */
public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 维护一个大顶堆，用来存放可以到达的加油站的油量，堆顶就是可达的加油站中油最多的
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int res = 0;
        int p = 0; // p用来遍历stations
        int n = stations.length;
        while (startFuel < target) {
            // 若当前加油站的距离小于等于 startFuel，说明可以到达，则把该加油站油量存入大顶堆。
            // 这个 while 循环的作用就是把所有当前能到达的加油站的油量都加到最大堆中
            // 注意下面是小于等于，因为等于时恰好可以到达这个加油站
            while (p < n && stations[p][0] <= startFuel) {
                queue.add(stations[p++][1]);
            }
            if (queue.isEmpty()) return -1; // 如果在某次循环中堆为空，直接返回-1
            startFuel += queue.poll(); // 否则，弹出堆顶元素，将其油量加到startFuel上
            res++;
        }
        return res;
    }
}

/*
我们关心的是在最小的加油次数下能达到的最远距离，那么每个加油站的油量就是关键因素，可以将所有能到达的加油站根据油量的多少放入大顶堆，这样每一次都
选择油量最多的加油站去加油，才能尽可能的到达最远的地方。这里需要一个变量p来记录当前遍历到的加油站的位置，外层循环的终止条件是 startFuel 小于 target，
然后在内部也进行循环，若当前加油站的距离小于等于 startFuel，说明可以到达，则把该加油站油量存入最大堆，这个 while 循环的作用就是把所有当前能到
达的加油站的油量都加到大顶堆中。这样取出的堆顶元素就是最大的油量，也是我们下一步需要去的地方（最想要去的地方，怎么能在半路就返航？！），假如此时
堆为空，则直接返回 -1，表示无法到达 target。否则就把堆顶元素加到 startFuel 上，此时的startFuel 就表示当前能到的最远距离。由于每次只能去一个
加油站，此时结果 res 也自增1，当 startFuel 到达 target 时，结果 res 就是最小的加油次数

参考：https://github.com/grandyang/leetcode/issues/871
 */
