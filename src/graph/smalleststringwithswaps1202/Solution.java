package src.graph.smalleststringwithswaps1202;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/11 13:14:27
 * description:
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 *
 * 参考：https://leetcode-cn.com/problems/smallest-string-with-swaps/solution/jiao-huan-zi-fu-chuan-zhong-de-yuan-su-b-qdn9/740445
 */
public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        // 使用map存储祖先节点到子节点列表的映射，存储并查集结果
        // 例如s = "dcab", pairs = [[0,3],[1,2]]
        // 3:[d,b]  2:[c,a]
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<>());
            }
            map.get(parent).add(s.charAt(i));
        }
        // 对map中的值进行排序
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2 - o1;
                }
            });
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = uf.find(i);
            List<Character> temp = map.get(x);
            sb.append(temp.remove(temp.size() - 1));
        }
        return sb.toString();
    }

    // for test
    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "dcab";
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(3);
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);
        list.add(temp);
        list.add(temp1);
        String res = s.smallestStringWithSwaps(test, list);
        System.out.println(res);
    }

    private static class UnionFind {
        private int[] parent;
        // 用一个数组rank[]记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。一开始，把所有元素的
        // rank（秩）设为1。合并时比较两个根节点，把rank较小者往较大者上合并
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        // 路径压缩
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // 按秩合并
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            // 如果fx == fy，表示这两个子树已经联通，
            if (fx == fy) {
                return;
            }

            // 应该把简单的树往复杂的树上合并（将秩小的树合并到秩大的树上）
            if (rank[fx] > rank[fy]) {
                parent[fy] = fx;
            } else {
                parent[fx] = fy;
            }

            if (rank[fx] == rank[fy]) {
                // 如果深度相同，则新的根节点的深度加1
                rank[fy]++;
            }
            count--; // 每union一次，子树数目减1
        }

        public int count() {
            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
