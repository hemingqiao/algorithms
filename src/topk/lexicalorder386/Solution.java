package src.topk.lexicalorder386;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 19:05:29
 * description:
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 *
 */
public class Solution {
    // 竟然AC了，我以为排序应该通过不了大集合的测试用例。。
    // 不过我估计之后的某个时间这个解法就不能通过了
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });
        return list;
    }


    // 字典序可以抽象为一颗树，所以从小到大输出字典序就是输出这棵树的先序遍历
    // 参考：https://leetcode-cn.com/problems/lexicographical-numbers/solution/java-zi-dian-xu-de-bian-li-by-ppppjqute/
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(list, n, i);
        }
        return list;
    }

    public void dfs(List<Integer> list, int n, int cur) {
        if (cur > n) return;
        list.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(list, n, cur * 10 + i);
        }
    }

    // 迭代解法
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> list = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10; // 进入下一层
            } else {
                if (curr >= n) curr /= 10;
                curr += 1;
                while (curr % 10 == 0) curr /= 10;
            }
        }
        return list;
    }
}
