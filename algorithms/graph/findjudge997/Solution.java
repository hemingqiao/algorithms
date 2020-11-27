package blogandquestion.algorithms.graph.findjudge997;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 21:35:46
 * description:
 * 参考：https://leetcode-cn.com/problems/find-the-town-judge/solution/tu-ru-du-chu-du-by-qing-mo-9/
 */
public class Solution {
    // 图，入度，出度
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1]; // 入度
        int[] outDegree = new int[N + 1]; // 出度
        for (int[] ints : trust) {
            inDegree[ints[1]]++; // ints[1]代表的节点入度加1
            outDegree[ints[0]]++; // ints[0]代表的节点出度加1
        }
        // 从1开始遍历是因为最小的起点便是1，没有0
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

/*
对于小镇中的关系，可以很容易的看成是一个有向图，trust[i]=[a,b]就表示途中 a节点指向 b节点的一条边，表示 a 信任 b。
入度和出度的概念可以去查一下，我这里就简单说一下
入度：以 a 为终点的边的数量 称为 a 的入度
出度：以 a 为起点的边的数量 称为 a 的出度
那么很容易在这道题中 a 的入度表示信任 a 的人的个数，a的出度表示 a 信任的人的个数
所以根据题意有唯一的一个人，被其他 N-1 个人信任而他信任 0个人即找到一个节点，该节点入度为 N-1出度为 0；
 */
