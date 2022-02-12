package src.array.numequivdominopairs1128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/26 11:11:13
 * description:
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *  
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 *
 */
public class Solution {
    // 需要利用好每个元素的值都不大于9这个条件
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] left : dominoes) {
            int min = Math.min(left[0], left[1]), max = Math.max(left[0], left[1]);
            map.put(min * 10 + max, map.getOrDefault(min * 10 + max, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            res += val * (val - 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = new int[][]{{2,2},{1,2},{1,2},{1,1},{1,2},{1,1},{2,2}};
        int res = s.numEquivDominoPairs(test);
        System.out.println(res);
    }

    // 参考：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/deng-jie-duo-mi-nuo-gu-pai-dui-de-shu-li-yjlz/
    public int numEquivDominoPairs1(int[][] dominoes) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : dominoes) {
            int val = pair[0] < pair[1] ? pair[0] * 10 + pair[1] : pair[1] * 10 + pair[0];
            Integer v = map.get(val);
            if (v == null) {
                map.put(val, 1);
            } else {
                map.put(val, v + 1);
            }
        }
        for (int val : map.values()) {
            res += val * (val - 1) / 2;
        }
        return res;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int res = 0;
        int[] record = new int[100];
        for (int[] pair : dominoes) {
            int val = pair[0] < pair[1] ? pair[0] * 10 + pair[1] : pair[1] * 10 + pair[0];
            record[val]++;
        }
        for (int val : record) {
            res += val * (val - 1) / 2;
        }
        return res;
    }
}
