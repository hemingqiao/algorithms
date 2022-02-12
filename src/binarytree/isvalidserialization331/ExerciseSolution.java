package src.binarytree.isvalidserialization331;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/12 14:14:07
 * description:
 */
public class ExerciseSolution {
    // 这个解法没有用split方法，反而执行的最快
    public boolean isValidSerialization(String preorder) {
        char[] chars = preorder.toCharArray();
        int n = chars.length;
        if (n == 0) return false;
        int leaves = 0, nodes = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ',') continue;
            if (chars[i] == '#') {
                leaves++;
            } else {
                int j = i + 1;
                while (j < n && chars[j] >= '0' && chars[j] <= '9') {
                    j++;
                    i++;
                }
                nodes++;
            }
            if (i != n - 1 && leaves > nodes) return false;
        }
        return leaves == nodes + 1;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "9,#,92,#,#";
        boolean res = es.isValidSerialization(test);
        System.out.println(res);
    }
}
