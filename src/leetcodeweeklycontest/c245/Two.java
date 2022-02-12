package src.leetcodeweeklycontest.c245;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/13 15:12:01
 * description:
 * 给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。
 *
 * 请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，然后从 s 中移除这些下标对应的 k 个字符。整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[removable[i]] 的字符，接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。
 *
 * 返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。
 *
 * 字符串的一个 子序列 是一个由原字符串生成的新字符串，生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcacb", p = "ab", removable = [3,1,0]
 * 输出：2
 * 解释：在移除下标 3 和 1 对应的字符后，"abcacb" 变成 "accb" 。
 * "ab" 是 "accb" 的一个子序列。
 * 如果移除下标 3、1 和 0 对应的字符后，"abcacb" 变成 "ccb" ，那么 "ab" 就不再是 s 的一个子序列。
 * 因此，最大的 k 是 2 。
 * 示例 2：
 *
 * 输入：s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
 * 输出：1
 * 解释：在移除下标 3 对应的字符后，"abcbddddd" 变成 "abcddddd" 。
 * "abcd" 是 "abcddddd" 的一个子序列。
 * 示例 3：
 *
 * 输入：s = "abcab", p = "abc", removable = [0,1,2,3,4]
 * 输出：0
 * 解释：如果移除数组 removable 的第一个下标，"abc" 就不再是 s 的一个子序列。
 *  
 *
 * 提示：
 *
 * 1 <= p.length <= s.length <= 10^5
 * 0 <= removable.length < s.length
 * 0 <= removable[i] < s.length
 * p 是 s 的一个 子字符串
 * s 和 p 都由小写英文字母组成
 * removable 中的元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-removable-characters
 *
 */
public class Two {
    int[] rr;

    public int maximumRemovals(String s, String p, int[] removable) {
        rr = removable;
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int l = 0, r = rr.length; // 根据题意，k最大可以取到rr.length
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(ss, pp, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public boolean check(char[] s, char[] p, int k) {
        // 字符数组是引用类型，需要需要复制出来一份进行更改
        s = s.clone();
        p = p.clone();
        for (int i = 0; i < k; i++) {
            s[rr[i]] = '#';
        }
        return isSubsequence(p, s);
    }

    // 检查s中的字符组成的字符串是否是t中的字符组成的字符串的子序列
    public boolean isSubsequence(char[] s, char[] t) {
        int a = s.length, b = t.length;
        if (a > b) return false;
        int i = 0, j = 0;
        for (; i < a; i++) {
            char temp = s[i];
            while (j < b && t[j] != temp) j++;
            if (j == b) break;
            j++;
        }
        return i == a && j <= b;
    }

    public static void main(String[] args) {
        Two t = new Two();
        String a = "abcbddddd";
        String b = "abcd";
        int[] r = new int[]{3, 2, 1, 4, 5, 6};
        int res = t.maximumRemovals(a, b, r);
        System.out.println(res);
    }
}

class AnotherSolution {
    // 这种写法优雅，但是比上面解法慢了一倍还多
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int l = 0, r = removable.length; // 根据题意，k最大可以取到rr.length
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < mid; i++) {
                sb.setCharAt(removable[i], '#');
            }
            if (check(p, sb.toString())) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public boolean check(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int a = ss.length, b = tt.length;
        int i = 0, j = 0;
        while (i < a && j < b) {
            if (ss[i] == tt[j]) ++i;
            ++j;
        }
        return i == a;
    }
}

class AnotherSolution1 {
    public boolean[] a = new boolean[100010];

    public int maximumRemovals(String s, String p, int[] removable) {
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int l = 0, r = removable.length; // 根据题意，k最大可以取到rr.length
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(ss, pp, removable, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public boolean check(char[] s, char[] p, int[] rm, int k) {
        for (int i = 0; i < a.length; i++) a[i] = false; // 重置a数组
        for (int j = 0; j < k; j++) a[rm[j]] = true;
        int l = 0, r = 0;
        while (l < s.length && r < p.length) {
            if (a[l]) {
                l++;
                continue;
            }
            if (s[l] == p[r]) r++;
            l++;
        }
        return r == p.length;
    }
}
