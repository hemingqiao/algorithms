package blogandquestion.algorithms.leetcodeweeklycontest.c236;



/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/11 10:15:45
 * description:
 */
public class Two {
    public int findTheWinner(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        int p = 0;
        while (nums.length > 1) {
            p = (p + k - 1) % nums.length;
            int[] temp = new int[nums.length - 1];
            int index = 0;
            for (int i = 0; i < temp.length; i++) {
                if (index == p) index++;
                temp[i] = nums[index++];
            }
            nums = temp;
        }
        return nums[0];
    }


    public int findTheWinner1(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = 1;
        int move = 0;
        int i = 0; // i指针用来移动
        int j = 0; // p指针用来计数，是否已经跳过了给定的人数
        while (move < n - 1) {
            i %= n;
            while (i < n) {
                j %= n;
                if (nums[i] == 1) j++;
                if (j == k) {
                    nums[i] = 0;
                    ++move;
                    if (move >= n - 1) break;
                    j = 0; // 重置j
                }
                i++;
            }
        }
        for (int p = 0; p < n; p++) {
            if (nums[p] == 1) return p + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Two t = new Two();
        int res = t.findTheWinner1(5, 2);
        System.out.println(res);
    }
}
