package blogandquestion.algorithms.binarysearch.hindex274;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/29 22:49:03
 * description:
 */
public class Solution {
    // h指数的意义就是存在h篇论文的引用大于等于h
    // 所以h指数最大为c.length，如判断5篇论文的h指数是否为5，只需要判断排序后，索引为0的元素是否大于等于5
    // 以此类推，判断h指数是否为4就是判断索引为1的元素是否大于等于4
    public int hIndex(int[] c) {
        int n = c.length;
        Arrays.sort(c);
        for (int h = n; h >= 1; h--) {
            if (c[n - h] >= h) return h;
        }
        return 0;
    }
}
