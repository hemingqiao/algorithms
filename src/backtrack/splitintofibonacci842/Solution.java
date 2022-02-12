package src.backtrack.splitintofibonacci842;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/08 08:52:33
 * description:
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 *
 * 参考：https://github.com/grandyang/leetcode/issues/842
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        backtracking(S, 0, res, out);
        return res;
    }

    private void backtracking(String S, int start, List<Integer> res, List<Integer> out) {
        if (!res.isEmpty()) return;
        if (start >= S.length() && out.size() >= 3) {
            res.addAll(out);
            return;
        }
        for (int i = start; i < S.length(); i++) {
            String cur = S.substring(start, i + 1);
            if ((cur.length() > 1 && cur.charAt(0) == '0') || cur.length() > 10) break;
            long num = Long.parseLong(cur);
            int len = out.size();
            if (num > Integer.MAX_VALUE) break;
            if (len >= 2 && num != out.get(len - 1) + out.get(len - 2)) continue;
            out.add((int) num);
            backtracking(S, i + 1, res, out);
            out.remove(out.size() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        String s = "112";
        List<Integer> res = new Solution().splitIntoFibonacci(s);
        System.out.println(res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/chuan-tong-gong-fu-dfshui-su-bian-li-pan-4lfv/
 */
class AnotherSolution {
    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        List<Integer> res = new ArrayList<>();
        return dfs(0, S, len, res) ? res : new ArrayList<>();
    }

    private boolean dfs(int start, String S, int len, List<Integer> res) {
        int size = res.size();
        if (start == len) {
            return size > 2;
        }
        int num = 0;
        for (int i = start; i < len; i++) {
            num = S.charAt(i) - '0' + num * 10;
            if (num < 0) {
                // 判断是否溢出整型范围
                return false;
            }
            if (size < 2 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add(num);
                if (dfs(i + 1, S, len, res)) {
                    return true;
                }
                res.remove(res.size() - 1); // 回溯
            }
            // 判断是否以0开头，如果以0开头，直接返回false，防止循环到下一位
            if (S.charAt(i) - '0' == 0 && i == start) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String test = "5813";
        List<Integer> res = as.splitIntoFibonacci(test);
        System.out.println(res);
    }
}
