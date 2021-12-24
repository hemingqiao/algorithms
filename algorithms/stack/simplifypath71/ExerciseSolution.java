package blogandquestion.algorithms.stack.simplifypath71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/15 16:57:16
 * description:
 */
public class ExerciseSolution {
    public String simplifyPath(String path) {
        // 使用 / 将原字符串分隔开
        String[] splited = path.split("/");
        int n = splited.length;
        String[] stack = new String[n];
        int p = 0;
        for (String t : splited) {
            if (t.equals("") || t.equals(".")) continue;
            if (t.equals("..")) {
                if (p <= 0) {
                    continue;
                } else {
                    p--;
                }
                continue;
            }
            stack[p++] = t;
        }
        if (p <= 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            sb.append("/");
            sb.append(stack[i]);
        }
        return sb.toString();
    }

    public String simplifyPath1(String path) {
        // 利用双端队列
        // 当把双端队列作为栈使用时，push即调用的双端队列的addFirst()方法，pop即调用的双端队列的removeFirst()方法
        Deque<String> queue = new ArrayDeque<>();
        String[] splited = path.split("/");
        for (String t : splited) {
            // 需要先判断t是否是 ".."，因为 ".." 对于 t 非空且 t 不等于 "."也成立，所以需要提前排除
            if ("..".equals(t)) {
                if (!queue.isEmpty()) queue.pollLast();
            } else if (!".".equals(t) && !"".equals(t)) {
                queue.add(t);
            }
        }
        // 结束循环后栈为空，返回 "/"
        if (queue.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : queue) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "/home//foo/";
        String res = es.simplifyPath1(test);
        System.out.println(res);
    }
}
