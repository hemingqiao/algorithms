package src.stack.decodestring394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 10:08:48
 * description:
 *
 * 参考：https://github.com/grandyang/leetcode/issues/394
 */
public class ExerciseSolution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> characters = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t >= '0' && t <= '9') {
                cnt = cnt * 10 + (t - '0');
            } else if (t == '[') {
                nums.offer(cnt);
                characters.offer(sb.toString());
                cnt = 0;
                sb = new StringBuilder();
            } else if (t == ']') {
                int k = nums.pollLast();
                String temp = sb.toString();
                for (int j = 1; j < k; j++) {
                    sb.append(temp);
                }
                sb.insert(0, characters.pollLast());
            } else {
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
