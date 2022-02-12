package src.greedy.predictpartyvictory649;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/11 08:53:55
 * description:
 * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 *
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 *
 * 禁止一名参议员的权利：
 *
 * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 *
 * 宣布胜利：
 *
 *           如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
 *
 *  
 *
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 *
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 *
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："RD"
 * 输出："Radiant"
 * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 * 示例 2：
 *
 * 输入："RDD"
 * 输出："Dire"
 * 解释：
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 *  
 *
 * 提示：
 *
 * 给定字符串的长度在 [1, 10,000] 之间.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dota2-senate
 *
 * 参考：https://github.com/grandyang/leetcode/issues/649
 */
public class Solution {
    // 用两个队列queue，把各自阵营的位置存入不同的队列里面，然后进行循环，每次从两个队列各取一个位置出来，看其大小关系，小的那个说明在前面，
    // 就可以把后面的那个Ban掉，所以要把小的那个位置要加回队列里面，但是不能直接加原位置，因为要等到下一轮才能再轮到他来Ban，所以要加上一
    // 个len（字符串的长度，表示等到下一轮），再排入队列。这样当某个队列为空时，退出循环，返回不为空的那个阵营
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        char[] chars = senate.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'R') {
                queue1.add(i);
            } else {
                queue2.add(i);
            }
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int i = queue1.poll();
            int j = queue2.poll();
            if (i < j) {
                queue1.add(i + len);
            } else {
                queue2.add(j + len);
            }
        }
        return queue1.isEmpty() ? "Dire" : "Radiant";
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/dota2-senate/solution/649-tan-xin-fa-lao-shi-fa-can-yi-yuan-tao-tai-you-/
 */
class AnotherSolutionIter {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        boolean R = true, D = true;// 使用R、D来标记senate中是否还有R、D
        int person = 0;// 标记变量person,当person>0时，表示R方可以淘汰D方；person<0时，表示D方可以淘汰R方。
        // R\D标记本轮循环中，senate是否存在R\D.（且是淘汰前的序列中）
        while (R && D) {
            R = false;
            D = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'R') {
                    R = true;
                    if (person < 0) // D方有权淘汰R方
                        chars[i] = '0'; // 将代表R的字符置为'0'
                    person++; // 无论有没有D淘汰掉R，person都++。有淘汰时，D的淘汰权用掉一次，person++；没有淘汰时，R的淘汰权增加1，person++
                } else if (chars[i] == 'D') {
                    D = true;
                    if (person > 0)
                        chars[i] = '0'; // // 将代表D的字符置为'0'
                    person--;
                }
            }
        }
        return person > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        AnotherSolutionIter as = new AnotherSolutionIter();
        String senate = "RD";
        String res = as.predictPartyVictory(senate);
        System.out.println(res);
    }
}
