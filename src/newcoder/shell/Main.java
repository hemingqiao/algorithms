package src.newcoder.shell;

import java.io.*;
import java.util.*;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/04 08:45:29
 * description:
 * 贝壳校招试题
 * 参见：https://www.nowcoder.com/test/28138075/summary
 */
public class Main {
    private int cnt;
    private int mod = (int) (1e9 + 7);

    // WA(TLE)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner cin = new Scanner(System.in);
        Main main = new Main();
//        int t = cin.nextInt();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
//            int n = cin.nextInt(), m = cin.nextInt();
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]), m = Integer.parseInt(in[1]);
            boolean[][] visited = new boolean[n][m];
            main.dfs(n, m, 0, 0, visited);
            if (main.cnt < main.mod) {
//                System.out.println(main.cnt);
                bw.write(Integer.toString(main.cnt));
            } else {
//                System.out.println(main.cnt % main.mod);
                bw.write(Integer.toString(main.cnt % main.mod));
            }
            bw.newLine();
            main.cnt = 0;
            bw.flush();
        }
    }

    public void dfs(int n, int m, int i, int j, boolean[][] visited) {
        if (i == n - 1 && j == m - 1) {
            cnt++;
            return;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j]) return;
        visited[i][j] = true;
        dfs(n, m, i + 1, j, visited);
        dfs(n, m, i, j + 1, visited);
        dfs(n, m, i, j - 1, visited);
        visited[i][j] = false;
    }
}

class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) {
            int x = cin.nextInt();
            int l = cin.nextInt();
            int[] temp = new int[2];
            temp[0] = Math.max(x - l, 0);
            temp[1] = x + l;
            intervals[i] = temp;
        }
        System.out.println(main1.resolve(intervals));
    }

    public int resolve(int[][] intervals) {
        // 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
        // 就越大，就越能保留更多的区间。因此，采取的贪心策略为，优先保留结尾小且不相交的区间。
        // 具体实现是，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
        // 择的区间不重叠的区间。
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int n = intervals.length;
        int left = intervals[0][1], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] > right) {
                ++cnt;
                left = interval[0];
                right = interval[1];
            }
        }
        return cnt;
    }
}

class Main1Mod {
    public static void main(String[] args) throws IOException {
        Main1Mod main1 = new Main1Mod();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int l = Integer.parseInt(in[1]);
            int[] temp = new int[2];
            temp[0] = Math.max(x - l, 0);
            temp[1] = x + l;
            intervals[i] = temp;
        }
        bw.write(Integer.toString(main1.resolve(intervals)));
        bw.newLine();
        bw.flush();
    }

    public int resolve(int[][] intervals) {
        // 在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
        // 就越大，就越能保留更多的区间。因此，采取的贪心策略为，优先保留结尾小且不相交的区间。
        // 具体实现是，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
        // 择的区间不重叠的区间。
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int n = intervals.length;
        int left = intervals[0][1], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] > right) {
                ++cnt;
                left = interval[0];
                right = interval[1];
            }
        }
        return cnt;
    }
}

class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) nums[j] = cin.nextInt();
            System.out.println(main2.resolve(nums, m));
        }
    }

    public int resolve(int[] nums, int m) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int cnt = 0;
        if (nums[0] > m) return cnt;
        for (int i = 0; i < n; i++) {
            if (res + nums[i] <= m) {
                ++cnt;
                res += nums[i];
            }
        }
        return cnt;
    }
}

class Main3 {
    // WA
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long n = cin.nextLong(), m = cin.nextLong();
        long total = n * m;
        long mod = total % 3;
        if (mod == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}

