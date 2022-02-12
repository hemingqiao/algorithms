package src.graph.calcequation399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/06 13:13:50
 * description:
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 *  
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 *
 * 图和并查集，并不理解
 * 参考：https://leetcode-cn.com/problems/evaluate-division/solution/ni-zhen-de-zhi-dao-bing-cha-ji-de-gou-zao-guo-chen/
 */
public class Solution {
    /**
     * key : 当前节点
     * value : 其父节点
     */
    private Map<String, String> parents = new HashMap<>();
    /**
     * key : 当前节点
     * value : 父节点/当前节点
     */
    private Map<String, Double> values = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String e = queries.get(i).get(0);
            String q = queries.get(i).get(1);
            if (!(parents.containsKey(e) && parents.containsKey(q))) {
                result[i] = -1;
                continue;
            }
            if (e.equals(q)) {
                result[i] = 1;
                continue;
            }
            String r1 = root(e);
            String r2 = root(q);
            if (!r1.equals(r2)) {
                // 如果两者不相等，说明两个节点是不连通的
                result[i] = -1;
                continue;
            }
            result[i] = pm(q) / pm(e);
        }
        return result;
    }

    private void union(String parent, String child, double value) {
        add(parent);
        add(child);
        String r1 = root(parent);
        String r2 = root(child);
        if (!r1.equals(r2)) {
            parents.put(r2, r1);
            values.put(r2, value * (pm(parent) / pm(child)));
        }
    }

    private void add(String x) {
        if (!parents.containsKey(x)) {
            parents.put(x, x);
            values.put(x, 1.0);
        }
    }


    /**
     * 找到x的根节点
     */
    private String root(String x) {
        while (!parents.get(x).equals(x)) {
            x = parents.get(x);
        }
        return x;
    }


    /**
     * 循环的pm函数
     */
    private double pm(String x) {
        double v = 1;
        while (!parents.get(x).equals(x)) {
            v *= values.get(x);
            x = parents.get(x);
        }
        return v;
    }

//    /**
//     * 递归的pm函数
//     * @param x
//     * @return
//     */
//    private double pm(String x){
//        return parents.get(x).equals(x)?1:values.get(x)*pm(parents.get(x));
//    }

}
