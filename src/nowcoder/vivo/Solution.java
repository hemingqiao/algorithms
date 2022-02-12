package src.nowcoder.vivo;

import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/07 19:43:42
 * description:
 */
public class Solution {
    public String compileSeq(String input) {
        // 定义一个优先队列，存放所有没有依赖的元素（从小到大排序）
        // 默认就是小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        String[] split = input.split(",");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(split[i]);
            nums[i] = t;
            if (t == -1) {
                queue.offer(i); // 将没有依赖的元素放入优先队列中
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(",");

            // 当完成编译完成后，依赖该文件的文件此时也不存在依赖了
            // 例如:加入A依赖B，当B完成编译后，A也不存在依赖了
            // 将其加入到队列中
            for (int i = 0; i < n; i++) {
                if (nums[i] == x) queue.offer(i);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "1,2,-1,1";
        String res = s.compileSeq(input);
        System.out.println(res);
    }
}
