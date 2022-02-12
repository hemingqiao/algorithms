package src.dfs.pondsizeslcci1619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/03 22:07:54
 * description:
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 *
 * 参考：https://leetcode-cn.com/problems/pond-sizes-lcci/solution/java-dfsqiu-jie-chi-tang-mian-ji-by-ggeorge500/
 */
public class Solution {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int temp;
        // 遍历矩阵内的每个元素
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                // 只有当前位置为水域时，才进行搜索
                if (land[i][j] == 0) {
                    temp = dfs(land, i, j);
                    if (temp != 0) list.add(temp);
                }
            }
        }

//        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        // 上面使用流的方法固然简洁优雅，但是是以执行时间为代价的😂
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int dfs(int[][] land, int i, int j) {
        int num = 0; // 池塘的大小
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return num;
        }
        num++;
        land[i][j] = -1; // 将访问过的池塘的值改为-1，避免再次搜索到

        num += dfs(land, i - 1, j); // 上方
        num += dfs(land, i, j + 1); // 右方
        num += dfs(land, i + 1, j); // 下方
        num += dfs(land, i, j - 1); // 左方
        num += dfs(land, i - 1, j - 1); // 左上方
        num += dfs(land, i - 1, j + 1); // 右上方
        num += dfs(land, i + 1, j + 1); // 右下方
        num += dfs(land, i + 1, j - 1); // 左下方

        return num;
    }
}
