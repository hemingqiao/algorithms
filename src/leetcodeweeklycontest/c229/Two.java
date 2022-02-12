package src.leetcodeweeklycontest.c229;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/21 12:49:31
 * description:
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 *
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 *
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 *
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 *
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 *  
 *
 * 提示：
 *
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 *
 */
public class Two {
    // 没理解
    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int n = chars.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') continue;
            for (int j = 0; j < n; j++) {
                answer[j] += Math.abs(i - j);
            }
        }
        return answer;
    }

    public int[] minOperations1(String boxes) {
        char[] chars = boxes.toCharArray();
        int n = chars.length;
        int[] left = new int[n], right = new int[n];
        int ln = 0, total = 0;
        for (int i = 0; i < n; i++) {
            left[i] = total;
            if (chars[i] == '1') ln++;
            total += ln;
        }
        int rn = 0;
        total = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = total;
            if (chars[i] == '1') rn++;
            total += rn;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }
        return ans;
    }

    // 1.找到所有的1，并用list记录他们的索引位置
    // 2.准备好结果int[]res,将每个索引移动到i处，需要绝对值｜j-i｜步操作，加和得到结果
    public int[] minOperations2(String boxes) {
        List<Integer> list = new ArrayList<>();
        int n = boxes.length();
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') list.add(i);
        }
        int[] res = new int[boxes.length()];
        for (int i = 0; i < n; i++) {
            int times = 0;
            for (int j : list) {
                times += Math.abs(j - i);
            }
            res[i] = times;
        }
        return res;
    }
}
