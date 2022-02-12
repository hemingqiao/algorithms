package src.array.checkstraightline1232;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 10:01:16
 * description:
 */
public class ExerciseSolution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (coordinates[0][0] == coordinates[n - 1][0]) {
            for (int i = 1; i < n - 1; i++) {
                if (coordinates[i][0] != coordinates[0][0]) return false;
            }
            return true;
        }
        double k = (coordinates[n - 1][1] - coordinates[0][1]) * 1.0 / (coordinates[n - 1][0] - coordinates[0][0]);
        double b = coordinates[0][1] - k * coordinates[0][0];
        for (int i = 1; i < n - 1; i++) {
            int[] point = coordinates[i];
            if (point[1] != k * point[0] + b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ExerciseSolution s = new ExerciseSolution();
        int[][] test = new int[][]{{2, 1}, {4, 2}, {6, 3}};
        boolean res = s.checkStraightLine(test);
        System.out.println(res);
    }

    // 参考：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/san-dian-xiang-chai-zhi-bi-li-chao-99-by-co4x/
    // 利用斜率相等，进行叉乘
    // 同时也不需要对横坐标相等进行特判了
    // 但是需要注意的是，如果坐标比较大，整型会有溢出的风险，可以将乘积转为long类型
    public boolean checkStraightLine1(int[][] coordinates) {
        int n = coordinates.length;
        for (int i = 1; i < n - 1; i++) {
            if ((coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i + 1][0] - coordinates[i][0])
                    != (coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1])) {
                return false;
            }
        }
        return true;
    }
}
