package src.acwing.monotonic;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/20 23:16:15
 * description:
 * 给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
 *
 * 输入格式
 * 第一行包含整数 N，表示数列长度。
 *
 * 第二行包含 N 个整数，表示整数数列。
 *
 * 输出格式
 * 共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。
 *
 * 数据范围
 * 1 ≤ N ≤ 10^5
 * 1 ≤ 数列中元素 ≤ 10^9
 * 输入样例：
 * 5
 * 3 4 2 7 5
 * 输出样例：
 * -1 3 -1 2 2
 */
public class MonoStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            while (!q.isEmpty() && q.peek() >= x) q.poll();
            if (!q.isEmpty()) System.out.print(q.peek() + " ");
            else System.out.print(-1 + " ");
            q.offerFirst(x);
        }
    }

    /*
    对于双端队列ArrayDeque来说，offer是队列入队，队尾添加元素，poll是元素出队，队首弹出元素
    如果用ArrayDeque来模拟栈的话，则是队首入队，队首弹出，所以入栈不能使用offer，而要使用offerFirst
     */
}
