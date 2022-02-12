package src.string.mindistance72;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/03 20:14:51
 * description:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 * 参考：https://github.com/grandyang/leetcode/issues/72
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int m = chars1.length, n = chars2.length;
        int[][] memo = new int[m][n];
        return helper(chars1, 0, chars2, 0, memo);
    }

    public int helper(char[] words1, int i, char[] words2, int j, int[][] memo) {
        if (i == words1.length) return words2.length - j;
        if (j == words2.length) return words1.length - i;
        if (memo[i][j] > 0) return memo[i][j];
        int res = 0;
        if (words1[i] == words2[j]) {
            return helper(words1, i + 1, words2, j + 1, memo);
        } else {
            int insertCnt = helper(words1, i, words2, j + 1, memo);
            int deleteCnt = helper(words1, i + 1, words2, j, memo);
            int replaceCnt = helper(words1, i + 1, words2, j + 1, memo);
            res = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
        }
        return memo[i][j] = res;
    }

    /*
    对于当前比较的两个字符 word1[i] 和 word2[j]，若二者相同，一切好说，直接跳到下一个位置。
    若不相同，有三种处理方法，
        首先是直接插入一个 word2[j]，那么 word2[j] 位置的字符就跳过了，接着比较 word1[i] 和 word2[j+1] 即可。
        第二个种方法是删除，即将 word1[i] 字符直接删掉，接着比较 word1[i+1] 和 word2[j] 即可。
        第三种则是将 word1[i] 修改为 word2[j]，接着比较 word1[i+1] 和 word[j+1] 即可。

    注意这里的 insertCnt，deleteCnt，replaceCnt 仅仅是表示当前对应的位置分别采用了插入，删除，和替换操作，整体返回的最小距离，
    后面位置的还是会调用递归返回最小的
     */
}
