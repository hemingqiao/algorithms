package blogandquestion.algorithms.backtrack.exist79;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/17 14:56:41
 * description:
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/g6YKx_VoHOpVG6toLCpGtQ
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从满足要求的第一个字符位置开始查找
                if (board[i][j] == words[0]) {
                    if (backtracking(board, words, i, j, 0)) return true;
                }
            }
        }
        // 如果遍历完没有找到任何一条符合要求的路径，返回false
        return false;
    }

    private boolean backtracking(char[][] board, char[] word, int i, int j, int startIndex) {
        // 因为需要向上下左右四个方向进行递归查找，首先判断是否越界，如果i和j大于等于数组长度或者小于0，表明索引已经越界，直接返回false
        // 判断完是否越界之后需要判断当前字符与目标字符是否相等，如果不等，表明这条路径走不通
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[startIndex]) {
            return false;
        }
        // 如果已经匹配到所有的字符，返回true
        if (startIndex == word.length - 1) {
            return true;
        }
        char temp = board[i][j]; // 把当前左边的字符值保存，方便递归调用后回溯时复原
        board[i][j] = '.'; // 修改当前坐标值，避免被二次遍历到
        // 沿着当前坐标的上下左右四个方向进行递归查找
        // 同时利用了短路的性质，下面四个方向中如果任一方向返回true，则这个方向后面的方向便不会在进行搜索
        boolean res = backtracking(board, word, i - 1, j, startIndex + 1) // 上
                || backtracking(board, word, i, j + 1, startIndex + 1) // 右
                || backtracking(board, word, i + 1, j, startIndex + 1) // 下
                || backtracking(board, word, i, j - 1, startIndex + 1); // 左
        // 递归调用结束后进行回溯，复原坐标值
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};
        String word = "ABCCED";
        Solution s = new Solution();
        boolean res = s.exist(board, word);
        System.out.println(res);
    }
}
