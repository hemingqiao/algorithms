package blogandquestion.algorithms.leetcodeweeklycontest.c236;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/11 14:11:34
 * description:
 */
class MKAverage {
    // WA
    private int[] container = new int[100003];
    private int m;
    private int k;
    private int p = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        container[p++] = num;
    }

    public int calculateMKAverage() {
        if (p < m) return -1;
        int[] temp = new int[m];
        int index = 0;
//        for (int i = p - m; i < p; i++) temp[index++] = container[i];
        System.arraycopy(container, p - m, temp, 0, m);
        Arrays.sort(temp);
        int sum = 0;
        for (int j = k; j < m - k; j++) sum += temp[j];
        return sum / (m - k * 2);
    }
}
