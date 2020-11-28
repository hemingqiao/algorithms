package blogandquestion.algorithms.graph.isbipartite785;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 10:03:16
 * description:
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 *
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 *
 * 参考：https://leetcode-cn.com/problems/is-graph-bipartite/solution/bfs-dfs-bing-cha-ji-san-chong-fang-fa-pan-duan-er-/
 * 参考：https://leetcode-cn.com/problems/is-graph-bipartite/solution/pan-duan-er-fen-tu-by-leetcode-solution/
 */
public class Solution {
    // dfs + 染色法
    public boolean isBipartite(int[][] graph) {
        // 定义visited数组，值为0表示未被访问，值为 1 或者 -1 表示两种不同的颜色
        int[] visited = new int[graph.length];
        // 因为图中可能含有多个连通域，所以需要先判断顶点是否被访问，如果没有被访问，对这个顶点进行一轮dfs染色
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                // 染色未成功，返回false
                return false;
            }
        }
        return true;
    }

    // dfs方法对某个顶点进行染色，返回整个顶点是否正确的染色
    private boolean dfs(int[][] graph, int v, int color, int[] visited) {
        // 如果对某个顶点进行染色时，发现它已经被染色了，此时需要判断它的颜色是否与本次要染的色相同
        // 如果不同，说明此无向图无法被正确染色，返回false
        if (visited[v] != 0) {
            return visited[v] == color;
        }
        // 对当前顶点进行染色，并将当前顶点的所有邻接点都（递归的）染成相反的颜色
        visited[v] = color;
        for (int w : graph[v]) {
            if (!dfs(graph, w, -color, visited)) {
                return false;
            }
        }
        return true;
    }
}
