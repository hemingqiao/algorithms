package src.graph.numbersimilargroups839;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 09:31:23
 * description:
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 *
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 *
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 *
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 *  
 *
 * 备注：
 *
 *       字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/similar-string-groups
 *
 * 参考：https://leetcode-cn.com/problems/similar-string-groups/solution/bing-cha-ji-100-by-shui-ping-zuo-gv0s/
 */
public class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 已经连通则跳过该对字符串
                if (ufs.isConnected(i, j)) continue;
                // 否则，判断这两对字符串是否相似，相似则连通
                if (isSimilar(strs[i], strs[j])) {
                    ufs.union(i, j);
                }
            }
        }
        return ufs.count;
    }

    // 判断两个字符串是否是相似的
    public boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    static class UnionFindSet {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFindSet(int n) {
            rank = new int[n];
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return;
            }
            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
            } else {
                parent[fy] = fx;
            }
            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
        }

        public int count() {
            return count;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
