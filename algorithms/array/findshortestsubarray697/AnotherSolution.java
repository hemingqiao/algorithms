package blogandquestion.algorithms.array.findshortestsubarray697;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 20:16:12
 * description:
 * 参考：https://leetcode-cn.com/problems/degree-of-an-array/solution/qian-lu-qi-qu-wang-wo-men-ke-yi-hu-xiang-8nrv/
 */
public class AnotherSolution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Degree> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, new Degree(1, i, i));
            } else {
                Degree d = map.get(temp);
                d.degree++;
                d.end = i;
                map.put(temp, d);
            }
        }
        Degree res = Collections.max(map.values());
        return res.end - res.start + 1;
    }

    static class Degree implements Comparable {
        public int degree;
        public int start;
        public int end;

        public Degree(int degree, int start, int end) {
            this.degree = degree;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Degree d = (Degree) o;
            if (this.degree == d.degree) {
                // 度相同则比较起始位置，起始位置之间差值越小越大
                // return (d.end - d.start) - (this.end - this.start);
                return d.end - d.start - this.end + this.start;
            }
            return this.degree - d.degree;
        }
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int[] test = new int[]{1, 2, 2, 3, 1};
        int res = as.findShortestSubArray(test);
        System.out.println(res);
    }
}
