package blogandquestion.algorithms.leetcodeweeklycontest.c225;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/24 17:30:49
 * description:
 * 给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
 *
 * 操作的最终目标是满足下列三个条件 之一 ：
 *
 * a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
 * b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
 * a 和 b 都 由 同一个 字母组成。
 * 返回达成目标所需的 最少 操作数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = "aba", b = "caa"
 * 输出：2
 * 解释：满足每个条件的最佳方案分别是：
 * 1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
 * 2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
 * 3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
 * 最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。
 * 示例 2：
 *
 * 输入：a = "dabadd", b = "cda"
 * 输出：3
 * 解释：满足条件 1 的最佳方案是将 b 变为 "eee" 。
 *  
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 10^5
 * a 和 b 只由小写字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions
 *
 * 参考：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/solution/c-mo-ni-da-fa-hao-by-bndsbilly-nkaq/
 * 参考：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/solution/czui-jian-qian-zhui-he-hou-zhui-he-jie-f-znoc/
 */
public class Two {
    public int minCharacters(String a, String b) {
        char[] charsA = a.toCharArray(), charsB = b.toCharArray();
        int[] recordA = new int[26], recordB = new int[26];
        for (char c : charsA) recordA[c - 'a']++;
        for (char c : charsB) recordB[c - 'a']++;
        int t = charsA.length + charsB.length;
        int ret = t;

        // 实际上是要满足 a 中的字典序最大字母比 b 中的字典序最小字母小。也即需要找到一个基准字母，使得 a 中所有字母小于等于该基准值，
        // 且 b 中所有字母大于该基准值（也可以定义基准为 a 中所有字母小于，b 中所有字母大于等于）。为达到这个目标，所需的最少操作数也就
        // 是 a,b 两个字符串中不满足该要求的字母数量
        int case1 = t;
        for (int i = 0; i < 25; i++) {
            int cnt = 0;
            for (int j = i + 1; j < 26; j++) {
                cnt += recordA[j];
            }
            for (int k = 0; k <= i; k++) {
                cnt += recordB[k];
            }
            case1 = Math.min(case1, cnt);
        }
        ret = Math.min(ret, case1);

        int case2 = t;
        for (int i = 0; i < 25; i++) {
            int cnt = 0;
            for (int j = i + 1; j < 26; j++) {
                cnt += recordB[j];
            }
            for (int k = 0; k <= i; k++) {
                cnt += recordA[k];
            }
            case2 = Math.min(case2, cnt);
        }
        ret = Math.min(ret, case2);

        int case3 = t;
        for (int i = 0; i < 26; i++) {
            int cnt = 0;
            for (int j = 0; j < 26; j++){
                if (i == j) continue;
                cnt += recordA[j] + recordB[j];
            }
            case3 = Math.min(case3, cnt);
        }
        ret = Math.min(ret, case3);
        return ret;
    }


    public static void main(String[] args) {
        System.out.println('z' - 'a');
    }
}
