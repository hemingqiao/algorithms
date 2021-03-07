package blogandquestion.algorithms.leetcodeweeklycontest.d47;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/07 09:59:21
 * description:
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 *
 * 输入：s = "aabcbaa"
 * 输出：17
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings
 *
 */
public class Three {
    public int beautySum(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                cnt[chars[j] - 'a']++;
                // 对遍历过程中的每一个字串都统计字符出现的次数，并找出出现次数最多的和出现次数最少的
                // 例如对于字符串 abc -> a, ab, abc, b, bc, c
                for (int c : cnt) {
                    if (c > 0) {
                        max = Math.max(max, c);
                        min = Math.min(min, c);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }
}
