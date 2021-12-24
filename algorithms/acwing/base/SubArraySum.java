package blogandquestion.algorithms.acwing.base;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 10:25:50
 * description:
 */
public class SubArraySum {

}


class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[300010], s = new int[300010];
        List<Integer> alls = new ArrayList<>();
        List<Pair> add = new ArrayList<>(), query = new ArrayList<>();
        while (n-- > 0) {
            int x = in.nextInt(), c = in.nextInt();
            add.add(new Pair(x, c));
            alls.add(x);
        }
        while (m-- > 0) {
            int l = in.nextInt(), r = in.nextInt();
            query.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }
        // 去重
        // Set<Integer> set = new HashSet<>(alls); // HashSet不保证插入顺序，所以这里需要使用TreeSet
        /*Collections.sort(alls);
        TreeSet<Integer> set = new TreeSet<>(alls);
        List<Integer> uniqueAlls = new ArrayList<>(set);*/
        Collections.sort(alls);
        List<Integer> uniqueAlls = new ArrayList<>();
        for (int i = 0; i < alls.size(); i++) {
            if (i == 0 || !alls.get(i).equals(alls.get(i - 1))) uniqueAlls.add(alls.get(i));
        }

        // 处理插入
        for (Pair p : add) {
            int x = find(uniqueAlls, p.first);
            a[x] += p.second;
        }

        // 预处理前缀和
        for (int i = 1; i <= uniqueAlls.size(); i++) {
            s[i] = s[i - 1] + a[i];
        }

        // 处理查询
        for (Pair p : query) {
            int l = find(uniqueAlls, p.first), r = find(uniqueAlls, p.second);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    public static int find(List<Integer> arr, int x) {
        int l = 0, r = arr.size() - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 索引从1开始
        return l + 1;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
