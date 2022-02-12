package src.array.finddisappearednumbers448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/13 09:18:57
 * description:
 */
public class ExerciseSolution {
    // 使用额外空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] record = new int[n + 1];
        for (int i = 0; i < n; i++) {
            record[nums[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (record[i] == 0) list.add(i);
        }
        return list;
    }

    // 不使用额外空间
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                --i; // for循环会对i执行自增，所以这里先减掉1，使得下次循环时仍在前一个位置
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
