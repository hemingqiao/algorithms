package blogandquestion.algorithms.dp.findthewinner1823;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/10 08:34:43
 * description:
 */
public class Solution {
    // 约瑟夫环问题
    // see：https://www.acwing.com/video/2763/
    public int findTheWinner(int n, int k) {
        // f(n, k)代表n个人玩游戏，规则是第k个被淘汰，最后的幸存者的位置
        // f(0, k) == 0，边界，只有一个人的话，索引为0的玩家始终是获胜者
        return f(n, k) + 1;
    }

    public int f(int n, int k) {
        if (n == 1) return 0;
        return (f(n - 1, k) + k) % n;
    }
}
