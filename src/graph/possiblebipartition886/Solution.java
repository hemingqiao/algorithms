package src.graph.possiblebipartition886;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 10:29:55
 * description:
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 *
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 *
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * 对于 dislikes[i] == dislikes[j] 不存在 i != j
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/possible-bipartition
 *
 * 参考：https://leetcode-cn.com/problems/possible-bipartition/solution/ke-neng-de-er-fen-fa-by-leetcode/
 */
public class Solution {
    ArrayList<Integer>[] graph;
    HashMap<Integer, Integer> colors;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 利用给出的数据生成无向图
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        // 连接图
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        colors = new HashMap<>(); // 记录顶点和被染的色
        for (int node = 1; node <= N; node++) {
            // 当前顶点没有被染色，才进行染色，并判断染色是否成功
            if (!colors.containsKey(node) && !dfs(node, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int color) {
        if (colors.containsKey(node)) {
            // 如果当前顶点已经染色，判断其当前颜色是否和要染的色相同
            return colors.get(node) == color;
        }
        colors.put(node, color); // 否则，将当前顶点和被染的色记录在map中
        for (int i : graph[node]) {
            // 对当前顶点的联通点染上相反的颜色(color ^ 1)
            if (!dfs(i, color ^ 1)) {
                return false;
            }
        }
        return true;
    }
}
