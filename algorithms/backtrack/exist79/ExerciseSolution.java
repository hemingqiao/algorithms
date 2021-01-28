package blogandquestion.algorithms.backtrack.exist79;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/28 19:42:44
 * description:
 * 二刷
 */
public class ExerciseSolution {
    /*
    // version 1
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, m, n, used, 0, word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, boolean[][] used, int index, String target) {
        if (index == target.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || board[i][j] != target.charAt(index)) {
            return false;
        }
        used[i][j] = true;
        boolean res = dfs(board, i - 1, j, m, n, used, index + 1, target)
                || dfs(board, i, j + 1, m, n, used, index + 1, target)
                || dfs(board, i + 1, j, m, n, used, index + 1, target)
                || dfs(board, i, j - 1, m, n, used, index + 1, target);
        used[i][j] = false;
        return res;
    }
    */

    /*
    // version 2，因为目标字符串最大可能长度为300，所以用字符数组替代了字符串
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] words = word.toCharArray();
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, m, n, used, 0, words)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, boolean[][] used, int index, char[] words) {
        if (index == words.length) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || board[i][j] != words[index]) {
            return false;
        }
        used[i][j] = true;
        boolean res = dfs(board, i - 1, j, m, n, used, index + 1, words)
                || dfs(board, i, j + 1, m, n, used, index + 1, words)
                || dfs(board, i + 1, j, m, n, used, index + 1, words)
                || dfs(board, i, j - 1, m, n, used, index + 1, words);
        used[i][j] = false;
        return res;
    }
    */

    /*
    // version 3，增加剪枝
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 剪枝，只有当前位置字符与目标字符串首字符相同时才进行深度优先搜索
                if (words[0] == board[i][j]) {
                    if (backtrack(board, used, words, i, j, 0, m, n)) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, boolean[][] used, char[] target, int i, int j, int index, int m, int n) {
        if (index == target.length) return true;
        if (i < 0 || i >= m || j < 0 || j > n || used[i][j] || board[i][j] != target[index]) {
            return false;
        }
        used[i][j] = true;
        boolean res = backtrack(board, used, target, i - 1, j, index + 1, m, n)
                || backtrack(board, used, target, i, j + 1, index + 1, m, n)
                || backtrack(board, used, target, i + 1, j, index + 1, m, n)
                || backtrack(board, used, target, i, j - 1, index + 1, m, n);
        used[i][j] = false;
        return res;
    }
    */

    // 与version 3 不同的是，这个版本没有使用辅助的布尔数组来标记是否访问过，而是在原数组上进行修改来标记是否访问过
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (words[0] == board[i][j]) {
                    if (backtrack(board, words, 0, i, j, m, n)) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] words, int index, int i, int j, int m, int n) {
        if (index == words.length) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != words[index]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        boolean res = backtrack(board, words, index + 1, i - 1, j, m, n)
                || backtrack(board, words, index + 1, i, j + 1, m, n)
                || backtrack(board, words, index + 1, i + 1, j, m, n)
                || backtrack(board, words, index + 1, i, j - 1, m, n);
        board[i][j] = temp;
        return res;
    }
}
