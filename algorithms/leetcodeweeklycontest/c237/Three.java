package blogandquestion.algorithms.leetcodeweeklycontest.c237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/19 09:25:35
 * description:
 * 参考：https://leetcode-cn.com/problems/single-threaded-cpu/solution/java-you-xian-ji-dui-lie-zhu-xing-zhu-sh-bv22/
 */
public class Three {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] ts = new Task[n];
        for (int i = 0; i < n; i++) ts[i] = new Task(i, tasks[i]);
        // 按照开始时间进行排序
        Arrays.sort(ts, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.time[0] - o2.time[0];
            }
        });
        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.time[1] == o2.time[1]) return o1.id - o2.id;
                return o1.time[1] - o2.time[1];
            }
        });
        // 直接从第一个任务开始的时间开始累加计时
        long T = ts[0].time[0];
        // ret 表示返回值， idx 表示返回值中的下标
        int[] ret = new int[n];
        int idx = 0;
        int p = 0;
        // 把所有开始时间 time[0] 不超过 T 的任务加到优先级队列里面
        for (; p < n; p++) {
            if (ts[p].time[0] <= T) queue.offer(ts[p]);
            // 如果 p 指向的任务开始时间已经超过了 T，那么后面的都超过，就跳出来
            else break;
        }
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            // 处理完这个任务，时间上要累加，同时往返回值中记录下标
            T += task.time[1];
            ret[idx++] = task.id;
            // 增加空转时间对齐，因为可能出现 [1, 2], [100, 5] 这样的数据，这样前后不接
            if (p < n && queue.isEmpty() && T < ts[p].time[0]) T = ts[p].time[0];
            for (; p < n; p++) {
                // 把所有不超过当前时间 T 的元素都放到优先级队列里面去
                if (ts[p].time[0] <= T) queue.offer(ts[p]);
                // 如果 iter 指向的任务开始时间已经超过了 T，那么后面的都超过，就跳出来
                else break;
            }
        }
        return ret;
    }

    // 对象化每一个任务，id就是下标，time就是开始时间和持续时间
    static class Task {
        int id;
        int[] time;

        public Task(int id, int[] time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Three t = new Three();
        int[][] tasks = new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] ret = t.getOrder(tasks);
        System.out.println(Arrays.toString(ret));
    }
}
