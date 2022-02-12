package src.numbers.numsquares279;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 19:30:48
 * description:
 */
public class Solution {
    /**
     * 参考：https://leetcode-cn.com/problems/perfect-squares/solution/python3zui-ji-chu-de-bfstao-lu-dai-ma-gua-he-ru-me/231743
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll();

                for (int j = 1; j * j <= cur; j++) {
                    int temp = cur - j * j;
                    if (temp == 0) return level;
                    if (!visited.contains(temp)) queue.add(temp);
                    visited.add(temp);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        int res = new Solution().numSquares(12);
        System.out.println(res);
    }
}
