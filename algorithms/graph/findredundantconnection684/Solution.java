package blogandquestion.algorithms.graph.findredundantconnection684;

import blogandquestion.algorithms.graph.UnionFindSet;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/13 10:19:44
 * description:
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFindSet ufs = new UnionFindSet(n + 1);
        for (int i = 0; i < n; i++) {
            int node1 = edges[i][0], node2 = edges[i][1];
            if (ufs.find(node1) != ufs.find(node2)) {
                ufs.union(node1, node2);
            } else {
                return edges[i];
            }
        }
        return new int[0];
    }
}
