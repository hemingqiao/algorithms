package blogandquestion.algorithms.greedy.issubsequence392;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/10 16:24:43
 * description: 使用贪心算法。速度稍慢。
 *
 * 本题询问的是，s 是否是 t 的子序列，因此只要能找到任意一种 s 在 t 中出现的方式，即可认为 s 是 t 的子序列。
 * 而当我们从前往后匹配，可以发现每次贪心地匹配靠前的字符是最优决策。
 * 假定当前需要匹配字符 c，而字符 c 在 t 中的位置 x1和 x2 出现（x1 < x2），那么贪心取 x1是最优解，因为 x2后面能取到的字符，
 * x1也都能取到，并且通过 x1与 x2之间的可选字符，更有希望能匹配成功。
 * 这样，我们初始化两个指针 i 和 j，分别指向 s 和 t 的初始位置。每次贪心地匹配，匹配成功则 i 和 j 同时右移，匹配 s 的下一个位置，
 * 匹配失败则 j 右移，i 不变，尝试用 t 的下一个字符匹配 s。
 * 最终如果 i 移动到 s 的末尾，就说明 s 是 t 的子序列。
 *
 * see: https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
