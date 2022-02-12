package src.binary.counttriplets1442;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/18 11:37:37
 * description:
 */
public class ExerciseSolution {
    // 求解一个三元组，显然需要三重循环
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = i; j < n; j++) {
                a ^= arr[j];
                int b = 0;
                for (int k = j + 1; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) ++count;
                }
            }
        }
        return count;
    }
}
